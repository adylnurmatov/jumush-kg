package kg.soft.jumushkg.service;



import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.web.dto.employer.EmployerDto;
import kg.soft.jumushkg.web.dto.user.UserDto;

import java.util.List;

public interface EmployerService {
    List<EmployerDto> getAll();

    EmployerDto update(Long id, EmployerDto employerDto);

    EmployerDto getById(Long id);

    void deleteById(Long id);

    List<Education> getEducations(Long id);

    List<String> getTypeOfEmployments();

    List<String> getSalaryTypes();

    List<String> getValutes();
    UserDto create(UserDto employerDto);
}
