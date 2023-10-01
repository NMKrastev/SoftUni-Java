package bg.softuni.BattleShipsApplication.model.mapper;

import bg.softuni.BattleShipsApplication.model.annotation.EncodedMapping;
import bg.softuni.BattleShipsApplication.model.dto.UserRegistrationDTO;
import bg.softuni.BattleShipsApplication.model.entity.User;
import bg.softuni.BattleShipsApplication.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User userRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO);
}
