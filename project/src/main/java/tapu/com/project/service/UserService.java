package tapu.com.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tapu.com.project.dto.UserDTO;
import tapu.com.project.model.User;
import tapu.com.project.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getName(),
                userDTO.getUsername(),
                userDTO.getAge(),
                userDTO.getEmail(),
                bCryptPasswordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

}
