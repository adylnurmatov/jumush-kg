package kg.soft.jumushkg.web.mapper.user;



import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.web.dto.user.UserDto;

import java.util.List;

public interface UserMapper {
    UserDto toDto(User user);
    List<UserDto> toDtos(List<User> user);
}
