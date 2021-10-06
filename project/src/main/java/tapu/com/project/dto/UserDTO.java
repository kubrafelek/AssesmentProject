package tapu.com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @Min(value = 0, message = "The age cannot be less than 0")
    @Max(value = 120, message = "The age cannot be greater than 120")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int age;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Length(min = 5, message = "Password size cannot be less than 5.")
    @NotBlank(message = "Password is mandatory")
    private String password;
}
