package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.entities.user.User;
import com.example.sd18_workshopmvcproject.entities.user.UserLoginDTO;
import com.example.sd18_workshopmvcproject.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @GetMapping("/users/register")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("user/register");
        return modelAndView;
    }

    @PostMapping("/users/login")
    public String doLogin(@Valid UserLoginDTO userLoginDTO) {

        final Optional<User> user = userService.login(userLoginDTO);

        if (user.isPresent()) {
            return "redirect:/home";
        }

        return "/user/login";
    }
}
