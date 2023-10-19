package bg.softuni.temp.model.mapper;

import bg.softuni.temp.model.dto.UserRegistrationDTO;
import bg.softuni.temp.model.entity.User;
import bg.softuni.temp.utils.EncodedMapping;
import bg.softuni.temp.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User userRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO);
}
