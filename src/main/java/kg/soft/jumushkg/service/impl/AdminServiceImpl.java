package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.repository.UserRepository;
import kg.soft.jumushkg.service.AdminService;
import kg.soft.jumushkg.web.dto.user.UserDto;
import kg.soft.jumushkg.web.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserDto> getAllUsers(String name, String userRole) {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public boolean deleteByAccount(String email) {
        userRepository.deleteByEmail(email);
        return true;
    }

    @Override
    public boolean deleteByAccount(String email, String password) {
        userRepository.deleteByEmailAndPassword(email, password);
        return true;
    }
}
