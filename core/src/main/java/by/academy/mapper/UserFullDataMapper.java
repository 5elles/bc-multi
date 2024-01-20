package by.academy.mapper;

import by.academy.dto.UserFullDataDTO;
import by.academy.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserFullDataMapper {
    UserFullDataMapper INSTANCE = Mappers.getMapper(UserFullDataMapper.class);
    User toModel(UserFullDataDTO dto);
}
