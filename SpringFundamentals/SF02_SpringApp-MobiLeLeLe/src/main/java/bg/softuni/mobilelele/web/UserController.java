package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.UserDTO;
import bg.softuni.mobilelele.service.impl.RoleServiceImpl;
import bg.softuni.mobilelele.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    private UserController(RoleServiceImpl roleService, UserServiceImpl userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public ModelAndView newUser(ModelAndView modelAndView) {

        modelAndView.addObject("roles", this.roleService.findAllRoles());

        modelAndView.setViewName("auth-register");

        return modelAndView;
    }

    @PostMapping("/users/register")
    public ModelAndView createUser(ModelAndView modelAndView, UserDTO userDTO) {

        this.userService.registerUser(userDTO);

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/users/login")
    public ModelAndView showLogin(ModelAndView modelAndView) {

        modelAndView.setViewName("auth-login");

        return modelAndView;
    }
}
