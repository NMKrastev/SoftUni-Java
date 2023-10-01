package bg.softuni.BattleShipsApplication.model.mapper;

import bg.softuni.BattleShipsApplication.model.dto.AddShipDTO;
import bg.softuni.BattleShipsApplication.model.entity.Ship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipMapper {

    Ship shipAddDtoToShip(AddShipDTO addShipDTO);
}
