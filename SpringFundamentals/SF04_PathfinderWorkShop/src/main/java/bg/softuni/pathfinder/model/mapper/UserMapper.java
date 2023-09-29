package bg.softuni.pathfinder.model.mapper;

import bg.softuni.pathfinder.annotation.EncodedMapping;
import bg.softuni.pathfinder.model.dto.userDTO.UserRegistrationDTO;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User userToUserDTO(UserRegistrationDTO userRegistrationDTO);
}
