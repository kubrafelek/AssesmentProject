package tapu.com.project.model;

import lombok.*;
import org.springframework.data.util.ProxyUtils;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Objects;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Url extends AbstractBaseEntity{

    @Lob //large object
    String original_url;
    String short_url;
}
