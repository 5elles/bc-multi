package by.academy.dto;
import by.academy.entity.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFullDataDTO {
    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 40, message = "The length of the string must be between 2 and 40")
    private String lastName;
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 20, message = "The length of the string must be between 2 and 20")
    private String firstName;
    @Size(max = 40, message = "The string cannot be larger than 40")
    private String middleName;
    @Size(min = 4, max = 50, message = "The length of the string must be between 4 and 50")
    @Email(message = "Email is not valid", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
