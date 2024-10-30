package kg.soft.jumushkg.web.dto.auth;



import kg.soft.jumushkg.domain.enums.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private Role role;
    private String accessToken;
    private String refreshToken;

}
