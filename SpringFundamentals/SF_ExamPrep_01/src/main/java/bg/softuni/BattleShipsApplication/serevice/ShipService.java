package bg.softuni.BattleShipsApplication.serevice;

import bg.softuni.BattleShipsApplication.model.dto.AddShipDTO;
import bg.softuni.BattleShipsApplication.model.entity.Category;
import bg.softuni.BattleShipsApplication.model.entity.Ship;
import bg.softuni.BattleShipsApplication.model.entity.User;
import bg.softuni.BattleShipsApplication.model.mapper.ShipMapper;
import bg.softuni.BattleShipsApplication.repository.CategoryRepository;
import bg.softuni.BattleShipsApplication.repository.ShipRepository;
import bg.softuni.BattleShipsApplication.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    private final ShipRepository shipRepository;
    private final UserService userService;
    private final CategoryRepository categoryRepository;
    private final CurrentUser currentUser;
    private final ShipMapper shipMapper;

    public ShipService(ShipRepository shipRepository, UserService userService,
                       CategoryRepository categoryRepository, CurrentUser currentUser,
                       ShipMapper shipMapper) {

        this.shipRepository = shipRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
        this.currentUser = currentUser;
        this.shipMapper = shipMapper;
    }

    public boolean addNewShip(AddShipDTO addShipDTO) {

        final User user = this.userService.findByUsername(this.currentUser.getUsername());

        final Category category = this.categoryRepository.findByName(addShipDTO.getCategory());

        final Ship ship = this.shipMapper.shipAddDtoToShip(addShipDTO);

        ship.setUser(user);
        ship.setCategory(category);

        return true;
    }

    public List<Ship> findAllUserShips() {

        List<Ship> ships = this.shipRepository.findAllByUserId(this.currentUser.getId());

        return ships;
    }

    public List<Ship> findAllEnemiesShips() {

        User user = this.userService.findByUsername(this.currentUser.getUsername());

        return this.shipRepository.findByUserNot(user);
    }

    public List<Ship> findAllShips() {

        return this.shipRepository.findAllByOrderByNameDescHealthDescPowerDesc();
    }

    public void battleShips(Long attackerId, Long defenderId) {

        final Ship attacker = this.shipRepository.findById(attackerId).get();

        final Ship defender = this.shipRepository.findById(defenderId).get();

        long attackerPower = attacker.getPower();

        long defenderHealth = defender.getHealth();

        if (defenderHealth - attackerPower <= 0) {
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(defenderHealth - attackerPower);
            this.shipRepository.save(defender);
        }
    }
}
