package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.mobilelele.service.RoleService;
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

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {

        this.userService = userService;
    }

    @ModelAttribute("userRegisterDTO")
    public void initUserRegisterModel(Model model) {
        model.addAttribute("userRegisterDTO", new UserRegisterDTO());
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {

        modelAndView.setViewName("auth-register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView,
                                 @Valid UserRegisterDTO userRegisterDTO,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            modelAndView.setViewName("redirect:/users/register");

            return modelAndView;
        }

        final boolean isUserRegistered = this.userService.registerUser(userRegisterDTO);

        if (isUserRegistered) {
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.setViewName("auth-register");
        }

        return modelAndView;
    }
}
