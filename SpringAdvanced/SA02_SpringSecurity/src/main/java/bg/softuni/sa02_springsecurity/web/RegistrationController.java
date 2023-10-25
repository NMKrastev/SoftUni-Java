package bg.softuni.sa02_springsecurity.web;

import bg.softuni.sa02_springsecurity.model.dto.UserRegistrationDTO;
import bg.softuni.sa02_springsecurity.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {

        this.userService.registerAndLogin(userRegistrationDTO);
        return "redirect:/";
    }
}
