package tapu.com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Login extends AbstractBaseEntity {

    @NotBlank(message = "Username is mandatory")
    @Column(name = "user_name", nullable = false)
    private String username;

    @Length(min = 5, message = "Password size cannot be less than 5.")
    @NotBlank(message = "Password is mandatory")
    @Column(name = "password", nullable = false)
    private String password;
}