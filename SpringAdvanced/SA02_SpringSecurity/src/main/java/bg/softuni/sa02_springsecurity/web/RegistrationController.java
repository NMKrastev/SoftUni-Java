package bg.softuni.sa02_springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegistrationController {


    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }

    /*@PostMapping("/register")
    public String register(UserRegisterDTO userRegisterDTO) {

       *//* userService.registerAndLogin(userRegisterDTO);*//*
        return "redirect:/";
    }*/
}
