package kg.soft.jumushkg.service;



import kg.soft.jumushkg.web.dto.user.UserDto;

import java.util.List;

public interface AdminService {
    List<UserDto> getAllUsers(String name, String userRole);

    boolean deleteByAccount(String email);

    boolean deleteByAccount(String email, String password);


}
