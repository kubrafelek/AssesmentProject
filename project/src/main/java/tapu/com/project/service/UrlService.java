package tapu.com.project.service;

import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.mappers.UrlMapper;
import tapu.com.project.model.Url;
import tapu.com.project.repository.UrlRepository;

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
        if (StringUtils.isNotEmpty(urlDTO.getOriginal_url())) {
            urlDTO.setShort_url(LOCALHOST + generateKey());
        }
        Url url = urlMapper.mapFromUrlDTOtoUrl(urlDTO);
        return Optional.of(urlRepository.save(url));
    }

    public String generateKey() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
