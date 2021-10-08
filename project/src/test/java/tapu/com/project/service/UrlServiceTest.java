package tapu.com.project.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.exceptions.UrlIsAlreadyExistException;
import tapu.com.project.mappers.UrlMapper;
import tapu.com.project.model.Url;
import tapu.com.project.repository.UrlRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class UrlServiceTest {

    @Mock
    UrlRepository mockUrlRepository;

    @Mock
    UrlMapper mockUrlMapper;

    @Mock
    UrlIsAlreadyExistException exception;

    @InjectMocks
    UrlService urlService;

    @Test
    void generateShortLink() {
        Url expected = new Url();
        expected.setOriginal_url("https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular");

        when(mockUrlRepository.existsOriginalUrl(anyString())).thenReturn(Boolean.FALSE);
        when(mockUrlMapper.mapFromUrlDTOtoUrl(any())).thenReturn(expected);
        when(mockUrlRepository.save(any())).thenReturn(expected);

        UrlDTO urlDTO = new UrlDTO();
        Url actual = this.urlService.generateShortLink(urlDTO).get();

        assertEquals(expected, actual);
    }

    @Test
    void listAll() {
        List<Url> urlList = mockUrlRepository.findAll();
        assertNotNull(urlList);
    }

    @Test
    void deleteById() {
        when(mockUrlRepository.findById(anyLong())).thenReturn(Optional.empty());

    }
}