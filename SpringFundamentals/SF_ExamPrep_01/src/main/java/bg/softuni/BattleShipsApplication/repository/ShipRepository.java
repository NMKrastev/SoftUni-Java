package bg.softuni.BattleShipsApplication.repository;

import bg.softuni.BattleShipsApplication.model.entity.Ship;
import bg.softuni.BattleShipsApplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findAllByUserId(Long id);

    List<Ship> findByUserNot(User user);

    List<Ship> findAllByOrderByNameDescHealthDescPowerDesc();

    Ship findByName(String attackerName);
}
