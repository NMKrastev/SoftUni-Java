package bg.softuni.mobilelele.model.mapper;

import bg.softuni.mobilelele.model.dto.UserRegistrationDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.utils.EncodedMapping;
import bg.softuni.mobilelele.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


//Works with Lombok, but you have to add dependencies!!!
//implementation group: 'org.projectlombok', name: 'lombok-mapstruct-binding', version: '0.2.0'
//annotationProcessor 'org.projectlombok:lombok-mapstruct-binding:0.2.0'
@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    UserEntity userDtoToUserEntity(UserRegistrationDTO userRegistrationDTO);
}
