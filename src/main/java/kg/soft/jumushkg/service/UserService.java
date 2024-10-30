package kg.soft.jumushkg.service;


import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.web.dto.user.UserDto;

public interface UserService {
    User getById(Long userId);

    User getByEmail(String email);

    User getByUsername(String username);


    String changePassword(String email, String oldPassword, String newPassword);
    UserDto createUser(UserDto userDto);
}
