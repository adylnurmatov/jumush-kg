package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.domain.entity.user.JobSeeker;
import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.domain.enums.Role;
import kg.soft.jumushkg.repository.UserRepository;
import kg.soft.jumushkg.service.AuthService;
import kg.soft.jumushkg.service.UserService;
import kg.soft.jumushkg.web.dto.auth.RegistrationDto;
import kg.soft.jumushkg.web.dto.auth.UserRequest;
import kg.soft.jumushkg.web.dto.auth.UserResponse;
import kg.soft.jumushkg.web.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse login(final UserRequest loginRequest) {
        UserResponse userResponse = new UserResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
        );
        User user = userService.getByUsername(loginRequest.getUsername());
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getRole());
        userResponse.setAccessToken(jwtTokenProvider.createAccessToken(
                user.getId(), user.getUsername(), user.getRole())
        );
        userResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(
                user.getId(), user.getUsername())
        );
        return userResponse;
    }

    @Override
    public User registerUser(RegistrationDto registrationDto) {
        if (userRepository.findByEmail(registrationDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists.");
        }

        String hashedPassword = passwordEncoder.encode(registrationDto.getPassword());

        User user;
        if (registrationDto.getRole() == Role.JOB_SEEKER) {
            user = new JobSeeker();
            user.setUsername(registrationDto.getUsername());
            user.setEmail(registrationDto.getEmail());
            user.setPassword(hashedPassword);
            user.setRole(registrationDto.getRole());
        } else {
            user = new Employer();
            user.setUsername(registrationDto.getUsername());
            user.setEmail(registrationDto.getEmail());
            user.setPassword(hashedPassword);
            user.setRole(registrationDto.getRole());
        }

        return userRepository.save(user);
    }

    @Override
    public UserResponse refresh(final String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
