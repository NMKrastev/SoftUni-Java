package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.UserProfileDTO;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserProfileController {

    private final UserService userService;
    private final CurrentUser currentUser;

    public UserProfileController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }


    // TODO: Maybe the userId should be taken as @PathVariable instead of using the currentUser
    // FIXME: 24.9.2023 г. When Spring security knowledge is sufficient this will be fixed as mentioned above
    @GetMapping("/profile")
    public ModelAndView profile(ModelAndView modelAndView) {

        final UserProfileDTO userProfileDTO = this.userService.findUserProfile(currentUser.getUsername());

        modelAndView.addObject("user", userProfileDTO);

        modelAndView.setViewName("profile");

        return modelAndView;
    }
}
