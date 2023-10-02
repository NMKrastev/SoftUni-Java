package bg.softuni.BattleShipsApplication.web;

import bg.softuni.BattleShipsApplication.model.dto.UserRegistrationDTO;
import bg.softuni.BattleShipsApplication.serevice.UserService;
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
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {

        this.userService = userService;
    }

    @ModelAttribute("userRegistrationDTO")
    public void initUserRegistrationModel(Model model) {

        model.addAttribute("userRegistrationDTO", new UserRegistrationDTO());
        //return new UserRegistrationDTO();
    }

    @GetMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView) {

        modelAndView.setViewName("register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(ModelAndView modelAndView,
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

            modelAndView.setViewName("redirect:/");

        } else {

            modelAndView.setViewName("register");
        }

        return modelAndView;
    }
}
