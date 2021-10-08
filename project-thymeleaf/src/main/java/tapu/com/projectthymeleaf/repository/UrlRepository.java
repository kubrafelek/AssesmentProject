package tapu.com.projectthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tapu.com.projectthymeleaf.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
}
