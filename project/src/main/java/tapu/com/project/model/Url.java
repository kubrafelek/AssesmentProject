package tapu.com.project.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

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
