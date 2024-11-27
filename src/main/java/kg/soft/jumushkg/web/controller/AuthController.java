package kg.soft.jumushkg.web.controller;

import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.service.AuthService;
import kg.soft.jumushkg.service.UserService;
import kg.soft.jumushkg.web.dto.auth.RegistrationDto;
import kg.soft.jumushkg.web.dto.auth.UserRequest;
import kg.soft.jumushkg.web.dto.auth.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDto registrationDto) {
        return authService.registerUser(registrationDto);
    }

    @PostMapping("/login")
    public UserResponse login(@Validated @RequestBody UserRequest jwtRequest) {
        return authService.login(jwtRequest);
    }
}
