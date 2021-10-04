package tapu.com.project.service;

import com.google.common.hash.Hashing;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.mappers.UrlMapper;
import tapu.com.project.model.Url;
import tapu.com.project.repository.UrlRepository;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {

    @Autowired
    private final UrlRepository urlRepository;

    @Autowired
    private final UrlMapper urlMapper;

    public Optional<Url> generateShortLink(UrlDTO urlDTO) {

        if (StringUtils.isNotEmpty(urlDTO.getOriginal_url())) {
            String encodedUrl = encodeUrl(urlDTO.getOriginal_url());
            urlDTO.setShort_url(encodedUrl);
        }
        Url url = urlMapper.mapFromUrlDTOtoUrl(urlDTO);
        return Optional.of(urlRepository.save(url));
    }

    private String encodeUrl(String url) {
        return Hashing.murmur3_32().hashString(url.concat(LocalDateTime.now().toString()), StandardCharsets.UTF_8).toString();
    }
}
