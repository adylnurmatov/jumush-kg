package kg.soft.jumushkg.service.impl;

import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.domain.enums.EmploymentType;
import kg.soft.jumushkg.domain.enums.SalaryType;
import kg.soft.jumushkg.domain.enums.Valute;
import kg.soft.jumushkg.domain.exception.ResourceNotFoundException;
import kg.soft.jumushkg.repository.EmployerRepository;
import kg.soft.jumushkg.repository.UserRepository;
import kg.soft.jumushkg.service.EmployerService;
import kg.soft.jumushkg.web.dto.employer.EmployerDto;
import kg.soft.jumushkg.web.dto.user.UserDto;
import kg.soft.jumushkg.web.mapper.employer.EmployerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {
    private final UserRepository userRepository;
    private final EmployerMapper employerMapper;
    private final EmployerRepository employerRepository;
    @Override
    public List<EmployerDto> getAll() {
        return employerMapper.toDtos(employerRepository.findAll());
    }

    @Override
    public EmployerDto update(Long id, EmployerDto employerDto) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        employer.setEmail(employerDto.getEmail());
        employer.setRole(employerDto.getRole());
        employer.setPassword(employerDto.getPassword());
        employer.setUsername(employerDto.getUsername());
        employerRepository.saveAndFlush(employer);
        return employerDto;
    }

    @Override
    public EmployerDto getById(Long id) {
        return employerMapper.toDto(employerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND")));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Education> getEducations(Long id) {
        return null;
    }

    @Override
    public List<String> getTypeOfEmployments() {
        List<String> strings = new ArrayList<>();
        strings.add(String.valueOf(EmploymentType.WFH));
        strings.add(String.valueOf(EmploymentType.FULL_TIME));
        strings.add(String.valueOf(EmploymentType.HALF_TIME));
        return strings;
    }

    @Override
    public List<String> getSalaryTypes() {
        List<String> strings = new ArrayList<>();
        strings.add(String.valueOf(SalaryType.FIX));
        strings.add(String.valueOf(SalaryType.FULL));
        strings.add(String.valueOf(SalaryType.GIBRID));
        return strings;
    }

    @Override
    public List<String> getValutes() {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(Valute.USD));
        list.add(String.valueOf(Valute.RUB));
        list.add(String.valueOf(Valute.SOM));
        return list;
    }

    @Override
    public UserDto create(UserDto employerDto) {
        Employer employer = new Employer(
                employerDto.getUsername(),
                employerDto.getEmail(),
                employerDto.getPassword(),
                employerDto.getRole()
        );
        employerRepository.saveAndFlush(employer);
        return employerDto;
    }

}
