package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoggedInDTO;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserLoginDTO;
import com.example.sd18_workshopmvcproject.entities.user.dto.UserRegisterDTO;
import com.example.sd18_workshopmvcproject.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;
    private UserLoggedInDTO isUserLoggedIn = null;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public ModelAndView login(ModelAndView modelAndView) {

        modelAndView.setViewName("user/login");

        return modelAndView;
    }

    @PostMapping("/users/login")
    public ModelAndView doLogin(ModelAndView modelAndView, @Valid UserLoginDTO userLoginDTO) {

        final Optional<UserLoggedInDTO> isUserLoggedInDTO = this.userService.login(userLoginDTO);

        if (isUserLoggedInDTO.isPresent()) {

            this.isUserLoggedIn = isUserLoggedInDTO.get();

            modelAndView.setViewName("redirect:/");

            return modelAndView;
        }

        modelAndView.setViewName("/user/login");

        return modelAndView;
    }

    @GetMapping("/users/register")
    public ModelAndView register(ModelAndView modelAndView) {

        modelAndView.setViewName("user/register");

        return modelAndView;
    }

    @PostMapping("/users/register")
    public ModelAndView doRegister(ModelAndView modelAndView, @Valid UserRegisterDTO userRegisterDTO) {

        if(userRegisterDTO.validate()) {

            this.userService.registerUser(userRegisterDTO);

            modelAndView.setViewName("redirect:/");

            return modelAndView;
        }

        modelAndView.setViewName("user/register");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView doLogout(ModelAndView modelAndView) {

        if (this.isUserLoggedIn != null) {

            this.isUserLoggedIn = null;

            modelAndView.setViewName("redirect:/");

            return modelAndView;
        }

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }


    protected boolean isUserLoggedIn() {
        return this.isUserLoggedIn != null;
    }

    protected UserLoggedInDTO getLoggedInUser(){
        return this.isUserLoggedIn;
    }
}
