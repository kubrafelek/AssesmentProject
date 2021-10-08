package tapu.com.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.model.Url;
import tapu.com.project.service.UrlService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UrlController {

    @Autowired
    private final UrlService urlService;

    @PostMapping("/generate")
    public ResponseEntity<Url> generateShortUrl(@RequestBody UrlDTO urlDTO){
        Optional<Url> resultOptional = urlService.generateShortLink(urlDTO);
        return resultOptional.map(url -> new ResponseEntity<>(url, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("redirect/{shortLink}")
    public ResponseEntity<String> redirectToUrl(@PathVariable @Valid String shortLink){
       return new ResponseEntity<>("https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular", HttpStatus.OK);
    }

    @GetMapping("/listAllUrls")
    public ResponseEntity<List<Url>> listAll() {
        return new ResponseEntity<>(urlService.listAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUrl(@PathVariable @Valid long id) {
        return new ResponseEntity(urlService.deleteById(id), HttpStatus.OK);
    }



}
