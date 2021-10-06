package tapu.com.project.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tapu.com.project.model.Login;
import tapu.com.project.repository.LoginRepository;

import static java.util.Collections.emptyList;

@Service
public class UrlServiceImpl implements UserDetailsService {

    private LoginRepository loginRepository;

    public UrlServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);
        if (login == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(login.getUsername(), login.getPassword(), emptyList());
    }
}
