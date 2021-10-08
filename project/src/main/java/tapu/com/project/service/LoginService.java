package tapu.com.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tapu.com.project.dto.LoginDTO;
import tapu.com.project.model.Login;
import tapu.com.project.repository.LoginRepository;

@Service
public class LoginService {

    private LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void save(LoginDTO loginDTO) {
        mapToDTO(this.loginRepository.save(
                new Login(
                        loginDTO.getName(),
                        loginDTO.getUsername(),
                        loginDTO.getAge(),
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        ));
    }

    public static LoginDTO mapToDTO(Login login) {
        if (login != null) {
            return new LoginDTO(
                    login.getName(),
                    login.getUsername(),
                    login.getAge(),
                    login.getEmail(),
                    login.getPassword()
            );
        }
        return null;
    }

}