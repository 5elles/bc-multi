package by.academy.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String fullName;
    private String email;
    private String role;
}
