package by.academy;


import by.academy.dto.UserDTO;
import by.academy.dto.UserFullDataDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    private final UserService userService;
    private static final String USERS = "/users";
    private static final String USER = "/user";

    @GetMapping(value = USERS)
    public List<UserDTO> showAll() {
        LOGGER.info("Showing all the users");
        return userService.findAll();
    }

    @PostMapping(value = USER)
    public ResponseEntity<Void> save(@Valid @RequestBody UserFullDataDTO dto) {
        LOGGER.info("Trying to save new user");
        userService.save(dto);
        LOGGER.info("Finished trying to save the new user");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
