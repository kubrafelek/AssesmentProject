package tapu.com.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tapu.com.project.model.Url;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UrlRepositoryTest {

    @Autowired
    UrlRepository urlRepository;

    @Test
    void existsOriginalUrl() {
        Url url = new Url(" https://www.tapu.com/l/uygulamaya-ozel-kampanyali-tapular", "http://localhost:8080/url");
        urlRepository.save(url);

        boolean expected = urlRepository.existsOriginalUrl(url.getOriginal_url());

        assertTrue(expected);
    }
}