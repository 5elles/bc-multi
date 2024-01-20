package by.academy.impl;


import by.academy.UserService;
import by.academy.dto.UserDTO;
import by.academy.dto.UserFullDataDTO;
import by.academy.entity.User;
import by.academy.mapper.UserFullDataMapper;
import by.academy.mapper.UserListMapper;
import by.academy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        LOGGER.info("Getting all the users from the DB");
        List<User> userList = userRepository.showAll();
        return UserListMapper.INSTANCE.toDTO(userList);
    }

    @Override
    public void save(UserFullDataDTO dto) {
        LOGGER.warn("Trying to save new user in the DB");
        try {
            userRepository.save(UserFullDataMapper.INSTANCE.toModel(dto));
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
