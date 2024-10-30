package kg.soft.jumushkg.web.dto.employer;



import jakarta.validation.constraints.NotNull;
import kg.soft.jumushkg.domain.enums.Role;
import kg.soft.jumushkg.web.dto.validation.OnCreate;
import kg.soft.jumushkg.web.dto.validation.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class EmployerDto {
    @NotNull(message = "id cannot be null", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "username cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String username;
    @NotNull(message = "email cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String email;
    @NotNull(message = "password cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String password;
    @NotNull(message = "role cannot be null", groups = OnCreate.class)
    private Role role;
}
