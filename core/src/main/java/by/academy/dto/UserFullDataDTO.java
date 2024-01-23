package by.academy.dto;
import by.academy.entity.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFullDataDTO {
    @Size(min = 2, max = 40, message = "The length of the string must be between 2 and 40")
    @Pattern(regexp = "[A-Za-zÀ-ÖØ-Ý]+", message = "Allowed only latin letters!")
    private String lastName;
    @Size(min = 2, max = 20, message = "The length of the string must be between 2 and 20")
    @Pattern(regexp = "[A-Za-zÀ-ÖØ-Ý]+", message = "Allowed only latin letters!")
    private String firstName;
    @Size(max = 40, message = "The string cannot be larger than 40")
    @Pattern(regexp = "[A-Za-zÀ-ÖØ-Ý]*", message = "Allowed only latin letters!")
    private String middleName;
    @Size(min = 4, max = 50, message = "The length of the string must be between 4 and 50")
    @Email(message = "Email is not valid", regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
