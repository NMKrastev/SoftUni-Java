package bg.softuni.resellerapp.web;

import bg.softuni.resellerapp.service.UserBuyService;
import bg.softuni.resellerapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserBuyController {
    
    private final UserBuyService userBuyService;

    public UserBuyController(UserBuyService userBuyService) {
        this.userBuyService = userBuyService;
    }


    @GetMapping("/buy/{id}")
    public ModelAndView buyItem(ModelAndView modelAndView,
                                @PathVariable("id") Long id) {
        
        this.userBuyService.buyItem(id);
        
        modelAndView.setViewName("redirect:/home");
        
        return modelAndView;
    }
}
