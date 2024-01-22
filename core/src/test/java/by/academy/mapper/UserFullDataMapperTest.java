package by.academy.mapper;

import by.academy.dto.UserFullDataDTO;
import by.academy.entity.User;
import by.academy.entity.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFullDataMapperTest {
    @Test
    void givenDto_whenToModel_thenUser(){
        UserFullDataDTO dto = UserFullDataDTO.builder()
                .lastName("Last")
                .middleName("Middle")
                .firstName("First")
                .email("test@test.by")
                .role(Role.ADMINISTRATOR)
                .build();
        User model = UserFullDataMapper.INSTANCE.toModel(dto);
        assertAll(
                () -> assertEquals(model.getEmail(), dto.getEmail()),
                () -> assertEquals(model.getLastName(), dto.getLastName()),
                () -> assertEquals(model.getFirstName(), dto.getFirstName()),
                () -> assertEquals(model.getMiddleName(), dto.getMiddleName()),
                () -> assertEquals(model.getRole(), dto.getRole())
        );
    }
}