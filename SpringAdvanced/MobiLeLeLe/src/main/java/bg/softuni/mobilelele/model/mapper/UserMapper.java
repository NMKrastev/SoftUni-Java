package bg.softuni.mobilelele.model.mapper;

import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


//Works with Lombok, but you have to add dependencies!!!
//implementation group: 'org.projectlombok', name: 'lombok-mapstruct-binding', version: '0.2.0'
//annotationProcessor 'org.projectlombok:lombok-mapstruct-binding:0.2.0'
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDtoToUserEntity(UserRegistrationDTO userRegistrationDTO);
}
