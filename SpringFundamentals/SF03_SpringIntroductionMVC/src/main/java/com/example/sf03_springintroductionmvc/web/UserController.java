package com.example.sf03_springintroductionmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
//Alternative for writing "/user" on every method
//@RequestMapping("/user")
public class UserController {

    @GetMapping("/user")
    public String newUser(Model model) {

        model.addAttribute("num", 3);

        return "newuser";
    }

    //Same as Model

    /*@GetMapping("/user")
    public ModelAndView newUser(ModelAndView modelAndView) {

        modelAndView.addObject("num", 3);
        modelAndView.setViewName("newuser");

        return modelAndView;
    }

    @GetMapping("/user")
    public String newUser(ModelMap modelMap) {

        modelMap.put("num", 3);

        return "newuser";
    }*/

    @PostMapping("/user")
    public String createUser(UserDTO userDTO) {

        System.out.println("Creating new user... " + userDTO);

        return "usercreated";
    }
}
