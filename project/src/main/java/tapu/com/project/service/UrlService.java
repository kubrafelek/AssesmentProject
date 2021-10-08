package tapu.com.project.service;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.exceptions.UrlIsAlreadyExistException;
import tapu.com.project.mappers.UrlMapper;
import tapu.com.project.model.Url;
import tapu.com.project.repository.UrlRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.RandomStringUtils;

@Service
@RequiredArgsConstructor
public class UrlService {

    private static final String LOCALHOST = "http://localhost:8080/";

    @Autowired
    private final UrlRepository urlRepository;

    @Autowired
    private final UrlMapper urlMapper;

    public Optional<Url> generateShortLink(UrlDTO urlDTO) {

        boolean isUrlExists = urlRepository.existsOriginalUrl(urlDTO.getOriginal_url());

        if(isUrlExists){
            throw new UrlIsAlreadyExistException("Url " + urlDTO.getOriginal_url() + " already exist.");
        }

        if (StringUtils.isNotEmpty(urlDTO.getOriginal_url())) {
            urlDTO.setShort_url(LOCALHOST + generateKey());
        }
        Url url = urlMapper.mapFromUrlDTOtoUrl(urlDTO);
        return Optional.of(urlRepository.save(url));
    }

    public String generateKey() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    @Transactional(readOnly = true)
    public List<Url> listAll() {
        List<Url> urlList = new ArrayList<>();
        Iterable<Url> urlIterable = urlRepository.findAll();
        urlIterable.iterator().forEachRemaining(urlList::add);
        return urlList;
    }

    @Transactional
    public String deleteById(long id) {
        urlRepository.deleteById(id);
        return "Url with id " + id + " deleted.";
    }

}
