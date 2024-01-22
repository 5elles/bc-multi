package by.academy.mapper;

import by.academy.dto.UserDTO;
import by.academy.entity.User;
import by.academy.entity.enums.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    @Test
    void givenUser_whenToDto_thenReturnDto(){
        User user = User.builder()
                .id(1)
                .lastName("Last")
                .firstName("First")
                .middleName("Middle")
                .email("test@test.by")
                .role(Role.SALE_USER)
                .build();
        UserDTO dto = UserMapper.INSTANCE.toDto(user);
        assertNotNull(dto);
        assertAll(
                () -> assertEquals(user.getEmail(), dto.getEmail()),
                () -> assertEquals(user.getLastName() + " " + user.getFirstName() + " " + user.getMiddleName(), dto.getFullName()),
                () -> assertEquals(user.getRole().toString(), dto.getRole())
        );
    }
}