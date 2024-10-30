package kg.soft.jumushkg.web.controller;


import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.repository.UserRepository;
import kg.soft.jumushkg.service.EmployerService;
import kg.soft.jumushkg.web.dto.employer.EmployerDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployerController {
    private final EmployerService employerService;
    private final UserRepository userRepository;

    @GetMapping("profile/{id}")
    public EmployerDto getEmployerById(@PathVariable Long id,
                                       @RequestHeader(name="Authorization") String token) {
        return employerService.getById(id);
    }

    @PostMapping("update/employer/{id}")
    public EmployerDto  updateEmployer(@PathVariable Long id, @RequestBody EmployerDto employerRequests) {
        return employerService.update(id, employerRequests);
    }



    @GetMapping("/{id}/educations")
    public List<Education> education(@PathVariable Long id) {
        return employerService.getEducations(id);
    }

    @GetMapping("employers")
    public List<EmployerDto> getAllEmployers() {
        return employerService.getAll();
    }


    @GetMapping("/typeofEmployments")
    public List<String> responseEntity() {
        return employerService.getTypeOfEmployments();
    }

    @GetMapping("/salaryType")
    public List<String> salaryType() {
        return employerService.getSalaryTypes();
    }

    @GetMapping("getValute")
    public List<String> valute() {
        return employerService.getValutes();
    }

}
