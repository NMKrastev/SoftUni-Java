package bg.softuni.errorhandling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WhiteLabelTestController {

    @GetMapping("/test-whitelabel")
    public String testWhiteLabel() {
        throw new NullPointerException("Something went wrong!");
    }

    @GetMapping("iae")
    public String testIae() {
        throw new IllegalArgumentException("iae");
    }

}
