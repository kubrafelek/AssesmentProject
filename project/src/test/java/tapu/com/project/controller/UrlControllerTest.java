package tapu.com.project.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.model.Url;
import tapu.com.project.service.UrlService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UrlControllerTest {

    @Mock
    UrlService mockUrlService;

    @InjectMocks
    UrlController urlController;

    @Test
    void generateShortUrl() {
        Url url = new Url();
        url.setOriginal_url("https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular");
        Optional<Url> expected = Optional.of(url);
        when(mockUrlService.generateShortLink(any())).thenReturn(expected);

        UrlDTO urlDTO = new UrlDTO();
        Url actual = this.urlController.generateShortUrl(urlDTO).getBody();

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected.get(), actual)
        );

    }

    @Test
    void redirectToUrl() {
        ResponseEntity<String> actual = this.urlController.redirectToUrl("http://localhost:8080/aaa");
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    void listAll() {
        List<Url> url = mockUrlService.listAll();
        assertNotNull(url);
    }

    @Test
    void deleteUrl() {
        when(mockUrlService.deleteById(anyLong())).thenReturn(anyString());

        ResponseEntity<String> actual = this.urlController.deleteUrl(1);
        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }
}