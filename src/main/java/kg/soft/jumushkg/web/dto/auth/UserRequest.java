package kg.soft.jumushkg.web.dto.auth;


import jakarta.validation.constraints.NotNull;
import kg.soft.jumushkg.domain.enums.Role;
import lombok.Data;

@Data
public class UserRequest {
    @NotNull(message = "username must be not null")
    private String username;
    @NotNull(message = "password must be not null")
    private String password;
    @NotNull(message = "role must be not null")
    private Role role;
}
