package kg.soft.jumushkg.web.controller;


import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.domain.exception.ResourceNotFoundException;
import kg.soft.jumushkg.repository.UserRepository;
import kg.soft.jumushkg.repository.VacancyRepository;
import kg.soft.jumushkg.service.VacancyService;
import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;
import kg.soft.jumushkg.web.mapper.vacancy.VacancyMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;
    private final UserRepository userRepository;
    private final VacancyRepository vacancyRepository;
    private final VacancyMapper vacancyMapper;



    @GetMapping("/vacancies")
    public List<VacancyDto> all() {
        return vacancyMapper.toDtos(vacancyRepository.findAll());
    }


    @GetMapping("/vacancy/{vacancyId}")
    public VacancyDto getByIdVacancy(@PathVariable Long vacancyId) {

        return vacancyMapper.toDto(vacancyRepository.findById(vacancyId).orElseThrow(() ->
                new ResourceNotFoundException("vacancy not found with id: " + vacancyId)));
    }

    @PostMapping("/vacancy/{employerId}")
    public VacancyDto save(@PathVariable Long employerId,
                                @RequestBody VacancyDto vacancyRequest) {
        return vacancyService.saveVacancy(employerId, vacancyRequest);
    }


    @DeleteMapping("/delete/{vacancyId}")
    public boolean delete(@PathVariable("vacancyId") Long vacancyId) {
        return vacancyService.delete(vacancyId);
    }

    @GetMapping("/vacancy/search")
    public List<VacancyDto> vacancySearch(@RequestParam(required = false) String search) {
        return vacancyService.searchVacancy(search);
    }


    @GetMapping("/vacancies/{userId}")
    public List<VacancyDto> getAllMyVacancies(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User not found!" + userId));
        return vacancyService.getMyVacancies(user.getId());
    }

    @PostMapping("/update/vacancy/{vacancyId}")
    public VacancyDto updateVacancy(@PathVariable Long vacancyId,
                                         @RequestBody VacancyDto vacancyRequest) {

        return vacancyService.update(vacancyId, vacancyRequest);
    }


}
