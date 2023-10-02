package bg.softuni.BattleShipsApplication.model.mapper;

import bg.softuni.BattleShipsApplication.model.dto.AddShipDTO;
import bg.softuni.BattleShipsApplication.model.dto.ShipDTO;
import bg.softuni.BattleShipsApplication.model.entity.Ship;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipMapper {

    Ship shipAddDtoToShip(AddShipDTO addShipDTO);

    ShipDTO shipToShipDto(Ship ship);
}
