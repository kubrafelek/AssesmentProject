package tapu.com.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.model.Url;
import tapu.com.project.service.UrlService;

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

    @GetMapping("/{shortLink}")
    public ResponseEntity<Url> redirectToUrl(@PathVariable String shortLink){
       return redirectToUrl("https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular");
    }
}
