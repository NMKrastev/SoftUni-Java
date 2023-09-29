package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.model.dto.userDTO.UserRegistrationDTO;
import bg.softuni.pathfinder.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegistrationDTO")
    public void initUserRegistrationModel(Model model) {

        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {

        modelAndView.setViewName("register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView,
                                 @Valid UserRegistrationDTO userRegistrationDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegistrationDTO", userRegistrationDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);

            modelAndView.setViewName("redirect:/user/register");
        }

        final boolean isUserRegistered = this.userService.registerUser(userRegistrationDTO);

        if (isUserRegistered) {

            modelAndView.setViewName("redirect:/");

        } else {

            modelAndView.setViewName("register");
        }

        return modelAndView;
    }
}
