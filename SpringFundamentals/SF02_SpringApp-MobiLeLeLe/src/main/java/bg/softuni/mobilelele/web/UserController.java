package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.UserLoginDTO;
import bg.softuni.mobilelele.model.dto.UserRegisterDTO;
import bg.softuni.mobilelele.service.impl.RoleServiceImpl;
import bg.softuni.mobilelele.service.impl.UserServiceImpl;
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
public class UserController {

    private final RoleServiceImpl roleService;
    private final UserServiceImpl userService;

    public UserController(RoleServiceImpl roleService, UserServiceImpl userService) {

        this.roleService = roleService;
        this.userService = userService;
    }

    @ModelAttribute("userRegisterDTO")
    public void initUserModel(Model model) {
        model.addAttribute("userRegisterDTO", new UserRegisterDTO());
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {

        modelAndView.setViewName("auth-login");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView) {

        this.userService.logoutUser();

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, UserLoginDTO userLoginDTO) {
        //System.out.println("User is logged: " + this.userService.loginUser(userLoginDTO));

        final boolean isUserLoggedIn = this.userService.loginUser(userLoginDTO);

        if (isUserLoggedIn) {
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.setViewName("auth-login");
        }

        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView) {

        modelAndView.addObject("roles", this.roleService.findAllRoles());

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
