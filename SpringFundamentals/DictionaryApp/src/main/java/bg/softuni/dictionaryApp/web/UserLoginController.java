package bg.softuni.dictionaryApp.web;

import bg.softuni.dictionaryApp.model.dto.UserLoginDTO;
import bg.softuni.dictionaryApp.service.UserService;
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
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {

        this.userService = userService;
    }

    @ModelAttribute("userLoginDTO")
    public void initUserLoginModel(Model model) {

        model.addAttribute("userLoginDTO", new UserLoginDTO());
    }

    @GetMapping("/login")
    public ModelAndView userLogin(ModelAndView modelAndView) {

        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView userLogin(ModelAndView modelAndView,
                                  @Valid UserLoginDTO userLoginDTO,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO", bindingResult);

            modelAndView.setViewName("redirect:/users/login");

            return modelAndView;
        }

        final boolean isUserLoggedIn = this.userService.loginUser(userLoginDTO);

        if (isUserLoggedIn) {

            modelAndView.setViewName("redirect:/home");

        } else {

            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);

            redirectAttributes.addFlashAttribute("badCredentials", true);

            modelAndView.setViewName("redirect:/users/login");
        }

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView) {

        this.userService.logoutUser();

        modelAndView.setViewName("index");

        return modelAndView;
    }
}
