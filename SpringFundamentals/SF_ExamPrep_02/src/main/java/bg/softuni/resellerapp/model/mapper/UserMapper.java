package bg.softuni.resellerapp.model.mapper;

import bg.softuni.resellerapp.model.annotation.EncodedMapping;
import bg.softuni.resellerapp.model.dto.UserRegistrationDTO;
import bg.softuni.resellerapp.model.entity.User;
import bg.softuni.resellerapp.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User userRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO);
}
