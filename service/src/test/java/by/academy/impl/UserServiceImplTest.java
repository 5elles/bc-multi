package by.academy.impl;

import by.academy.UserService;
import by.academy.dto.UserDTO;
import by.academy.dto.UserFullDataDTO;
import by.academy.entity.User;
import by.academy.entity.enums.Role;
import by.academy.mapper.UserFullDataMapper;
import by.academy.mapper.UserListMapper;
import by.academy.mapper.UserMapper;
import by.academy.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;
    private User user1;
    private User user2;
    private UserFullDataDTO fullDataDTO;

    @BeforeEach
    public void setup(){
        user1 = User.builder()
                .id(1)
                .lastName("Last1")
                .firstName("First1")
                .middleName("Middle1")
                .email("test1@test.by")
                .role(Role.ADMINISTRATOR)
                .build();
        user2 = User.builder()
                .id(2)
                .lastName("Last2")
                .firstName("First2")
                .middleName("Middle2")
                .email("test2@test.by")
                .role(Role.SALE_USER)
                .build();
        fullDataDTO = UserFullDataDTO.builder()
                .lastName("Last3")
                .firstName("First3")
                .middleName("Middle3")
                .email("test3@test.by")
                .role(Role.SALE_USER)
                .build();
    }


    @DisplayName("a test for the findAll method")
    @Test
    void whenFindAll_thenReturnUserDtoList() {
        given(userRepository.showAll()).willReturn(List.of(user1, user2));
        List<UserDTO> all = userService.findAll();
        assertEquals(2, all.size());
        assertEquals(user1.getEmail(), all.get(0).getEmail());
        assertEquals(user2.getEmail(), all.get(1).getEmail());
    }

    @Test
    void save() {
        User newUser = User.builder()
                .lastName(fullDataDTO.getLastName())
                .middleName(fullDataDTO.getMiddleName())
                .firstName(fullDataDTO.getFirstName())
                .role(fullDataDTO.getRole())
                .email(fullDataDTO.getEmail())
                .build();
        given(userRepository.save(newUser)).willReturn(newUser);
        userService.save(fullDataDTO);
        verify(userRepository).save(newUser);
    }
}