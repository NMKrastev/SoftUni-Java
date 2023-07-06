package com.example.sd18_workshopmvcproject.contollers;

import com.example.sd18_workshopmvcproject.entities.user.UserLoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, UserLoginDTO userLoginDTO) {
        modelAndView.addObject("username", userLoginDTO.getUsername());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {
        modelAndView.setViewName("home") ;
        return modelAndView;
    }

}
