package tapu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tapu.com.project.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {


}
