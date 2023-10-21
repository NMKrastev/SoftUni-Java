package bg.softuni.dictionaryApp.model.mapper;

import bg.softuni.dictionaryApp.model.dto.UserRegistrationDTO;
import bg.softuni.dictionaryApp.model.entity.User;
import bg.softuni.dictionaryApp.utils.EncodedMapping;
import bg.softuni.dictionaryApp.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User userRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO);
}
