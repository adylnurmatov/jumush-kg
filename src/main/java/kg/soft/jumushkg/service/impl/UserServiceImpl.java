package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.domain.enums.Role;
import kg.soft.jumushkg.domain.exception.ResourceNotFoundException;
import kg.soft.jumushkg.repository.UserRepository;
import kg.soft.jumushkg.service.EmployerService;
import kg.soft.jumushkg.service.JobSeekerService;
import kg.soft.jumushkg.service.UserService;
import kg.soft.jumushkg.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JobSeekerService jobSeekerService;
    private final EmployerService employerService;

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> user =userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("NOT_FOUND");
        }
        return user.get();
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("NOT_FOUND");
        }
        return user.get();
    }
    @Override
    public String changePassword(String email, String oldPassword, String newPassword) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            return newPassword;
        }
        else{
            return oldPassword;
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userDto.getRole().equals(Role.EMPLOYER)){
            employerService.create(userDto);
        }
        else{
            jobSeekerService.create(userDto);
        }
        return userDto;
    }
}
