package by.academy.mapper;

import by.academy.dto.UserDTO;
import by.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = UserMapper.class)
public interface UserListMapper {
    UserListMapper INSTANCE = Mappers.getMapper(UserListMapper.class);
    List<UserDTO> toDTO(List<User> models);
}
