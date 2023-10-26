package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.service.UserService;
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
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {

        this.userService = userService;
    }

    @ModelAttribute("userRegistrationDTO")
    public void initUserRegisterModel(Model model) {
        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        //return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {

        modelAndView.setViewName("auth-register");

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

            modelAndView.setViewName("redirect:/users/register");

            return modelAndView;
        }

        final boolean isUserRegistered = this.userService.registerUser(userRegistrationDTO);

        if (isUserRegistered) {
            modelAndView.setViewName("redirect:/users/login");
        } else {
            modelAndView.setViewName("auth-register");
        }

        return modelAndView;
    }
}
