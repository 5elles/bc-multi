package by.academy;

import by.academy.dto.UserDTO;
import by.academy.dto.UserFullDataDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    void save(UserFullDataDTO dto);
}
