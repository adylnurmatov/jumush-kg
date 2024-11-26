package kg.soft.jumushkg.service;


import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.web.dto.auth.RegistrationDto;
import kg.soft.jumushkg.web.dto.auth.UserRequest;
import kg.soft.jumushkg.web.dto.auth.UserResponse;

public interface AuthService {

    UserResponse login(UserRequest userRequest);
    UserResponse refresh(String refreshToken);
    User registerUser(RegistrationDto registrationDto);
}
