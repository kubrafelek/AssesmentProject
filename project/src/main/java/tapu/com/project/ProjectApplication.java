package tapu.com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tapu.com.project.config.annotation.DeveloperInfo;

@SpringBootApplication
@EnableSwagger2
@DeveloperInfo(
        expertise = DeveloperInfo.Expertise.SENIOR,
        createdBy = "Kübra Felek",
        url = "https://github.com/kubrafelek",
        email = "kubra.felek@isik.edu.tr"
)

public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
