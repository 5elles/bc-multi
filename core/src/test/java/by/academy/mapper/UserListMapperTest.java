package by.academy.mapper;

import by.academy.dto.UserDTO;
import by.academy.entity.User;
import by.academy.entity.enums.Role;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserListMapperTest {
    @Test
    void givenListOfUsers_whenToDto_thenListOfDto(){
        User user = User.builder()
                .id(1)
                .lastName("Last1")
                .middleName("Middle1")
                .firstName("First1")
                .email("test1@test.by")
                .role(Role.CUSTOMER_USER)
                .build();

        User user1 = User.builder()
                .id(2)
                .lastName("Last2")
                .middleName("Middle2")
                .firstName("First2")
                .email("test2@test.by")
                .role(Role.CUSTOMER_USER)
                .build();

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);

        List<UserDTO> dtoList = UserListMapper.INSTANCE.toDTO(userList);

        assertEquals(userList.size(), dtoList.size());
        for(int i = 0; i < userList.size(); i++){
            User testUser = userList.get(i);
            UserDTO testDto = dtoList.get(i);
            assertAll(
                    () -> assertEquals(testUser.getEmail(), testDto.getEmail()),
                    () -> assertEquals(testUser.getLastName() + " " + testUser.getFirstName() + " " + testUser.getMiddleName(), testDto.getFullName()),
                    () -> assertEquals(testUser.getRole().toString(), testDto.getRole())
            );
        }
    }
}