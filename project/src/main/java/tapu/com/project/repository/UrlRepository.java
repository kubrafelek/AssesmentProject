package tapu.com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tapu.com.project.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url,Long> {

    @Query("select case when count (u)>0 then true else false end from Url u where u.original_url = ?1")
    boolean existsOriginalUrl(String original_url);
}
