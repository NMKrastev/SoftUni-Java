package com.example.planner_app.model.mapper;

import com.example.planner_app.utils.EncodedMapping;
import com.example.planner_app.model.dto.UserRegistrationDTO;
import com.example.planner_app.model.entity.User;
import com.example.planner_app.utils.PasswordEncoderMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = PasswordEncoderMapper.class)
public interface UserMapper {

    @Mapping(target = "password", qualifiedBy = EncodedMapping.class)
    User userRegistrationDtoToUser(UserRegistrationDTO userRegistrationDTO);
}
