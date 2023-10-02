package bg.softuni.BattleShipsApplication.web;

import bg.softuni.BattleShipsApplication.model.dto.ShipDTO;
import bg.softuni.BattleShipsApplication.serevice.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final ShipService shipService;

    public HomeController(ShipService shipService) {

        this.shipService = shipService;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        final List<ShipDTO> userShips = this.shipService.findAllUserShips();

        final List<ShipDTO> enemiesShips = this.shipService.findAllEnemiesShips();

        final List<ShipDTO> allShips = this.shipService.findAllShips();

        modelAndView.addObject("ships", userShips);

        modelAndView.addObject("enemiesShips", enemiesShips);

        modelAndView.addObject("allShips", allShips);

        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("home/data")
    public ModelAndView getShips(ModelAndView modelAndView,
                                 @RequestParam("attackerShip") String attackerName,
                                 @RequestParam("defenderShip") String defenderName) {

        this.shipService.battleShips(attackerName, defenderName);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }
}
