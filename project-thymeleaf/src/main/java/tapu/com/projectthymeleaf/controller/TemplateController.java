package tapu.com.projectthymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tapu.com.projectthymeleaf.model.Url;
import tapu.com.projectthymeleaf.model.User;
import tapu.com.projectthymeleaf.repository.UrlRepository;
import tapu.com.projectthymeleaf.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class TemplateController {
    private static final String LOCALHOST = "http://localhost:8080/";

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
        return "register_success";
    }

    @GetMapping("/urls")
    public String listUrls(Model model) {
        List<Url> listUrls = urlRepository.findAll();
        model.addAttribute("listUrls", listUrls);
        return "urls";
    }

    @GetMapping("/form")
    public String generateShortUrl(Model model) {
        model.addAttribute("url", new Url());
        log.info("Form geldi");
        return "generate_short_url";
    }

    @PostMapping("/generate")
    public String getShortUrl(@Valid Url url) {
        log.info("Metoda girildi ");

        url.setShortUrl(LOCALHOST + RandomStringUtils.randomAlphanumeric(5));
        url.setOriginalUrl(url.getOriginalUrl());
        urlRepository.save(url);

        return "redirect:/urls";
    }
}
