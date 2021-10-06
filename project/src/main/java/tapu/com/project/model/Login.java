package tapu.com.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class Login extends AbstractBaseEntity {
    @Column(name = "user_name", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

}