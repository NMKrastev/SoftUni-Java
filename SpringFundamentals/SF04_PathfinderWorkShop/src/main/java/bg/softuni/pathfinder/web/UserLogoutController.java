package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserLogoutController {

    private final UserService userService;

    public UserLogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView) {

        this.userService.logoutUser();

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
}
