package bg.softuni.sa02_springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/pages/all")
    public String all() {
        return "all";
    }

    @GetMapping("/pages/moderators")
    public String moderators() {
        return "moderators";
    }

    @GetMapping("/pages/admins")
    public String admins() {
        return "admins";
    }
}