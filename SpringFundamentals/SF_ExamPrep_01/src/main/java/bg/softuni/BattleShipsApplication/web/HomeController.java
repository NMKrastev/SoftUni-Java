package bg.softuni.BattleShipsApplication.web;

import bg.softuni.BattleShipsApplication.model.entity.Ship;
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

        final List<Ship> userShips = this.shipService.findAllUserShips();

        final List<Ship> enemiesShips = this.shipService.findAllEnemiesShips();

        final List<Ship> allShips = this.shipService.findAllShips();

        modelAndView.addObject("ships", userShips);

        modelAndView.addObject("enemiesShips", enemiesShips);

        modelAndView.addObject("allShips", allShips);

        modelAndView.setViewName("home");

        return modelAndView;
    }

    @GetMapping("home/data")
    public ModelAndView getShips(ModelAndView modelAndView,
                                 @RequestParam("attackerShip") Long attackerId,
                                 @RequestParam("defenderShip") Long defenderId) {

        this.shipService.battleShips(attackerId, defenderId);

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

}
