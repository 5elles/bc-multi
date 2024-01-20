package by.academy.mapper;

import by.academy.dto.UserDTO;
import by.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(expression = "java(model.getLastName() + ' ' +  model.getFirstName() + ' ' + model.getMiddleName())",
            target = "fullName")
    UserDTO toDto(User model);
}
