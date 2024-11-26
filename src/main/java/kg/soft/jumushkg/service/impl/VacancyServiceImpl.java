package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import kg.soft.jumushkg.domain.enums.VacancyStatus;
import kg.soft.jumushkg.repository.EmployerRepository;
import kg.soft.jumushkg.repository.VacancyRepository;
import kg.soft.jumushkg.service.VacancyService;
import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;
import kg.soft.jumushkg.web.mapper.vacancy.VacancyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;
    private final EmployerRepository employerRepository;

    @Override
    public VacancyDto saveVacancy(Long id, VacancyDto vacancyDto) {
        Vacancy vacancy = vacancyMapper.toEntity(vacancyDto);
        vacancyRepository.save(vacancy);
        return vacancyDto;
    }
    @Override
    public boolean delete(Long id) {
        vacancyRepository.deleteById(id);
        return true;
    }

    @Override
    public List<VacancyDto> getAll() {
        return vacancyMapper.toDtos(vacancyRepository.findAll());
    }

    @Override
    public VacancyDto update(Long id, VacancyDto vacancyRequest) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(() -> new BadCredentialsException("NOT_FOUND"));
        vacancy.setCompanyName(vacancyRequest.getCompanyName());
        vacancy.setDescription(vacancyRequest.getDescription());
        vacancy.setSkills(vacancyRequest.getSkills());
        vacancy.setCountry(vacancyRequest.getCountry());
        vacancy.setCity(vacancyRequest.getCity());
        vacancy.setAboutCompany(vacancyRequest.getAboutCompany());
        vacancy.setEmploymentType(vacancyRequest.getEmploymentType());
        vacancy.setCreatedAt(vacancyRequest.getCreatedAt());
        vacancy.setVacancyStatus(vacancyRequest.getVacancyStatus());
        vacancy.setSalary(vacancyRequest.getSalary());
        vacancy.setViews(vacancyRequest.getViews());
        vacancy.setRespondents(vacancyRequest.getRespondents());
        vacancy.setPosition(vacancyRequest.getPosition());
        vacancyRepository.save(vacancy);
        return vacancyRequest;
    }


    public List<VacancyDto> jobSeekerVacancies() {
        return vacancyMapper.toDtos(vacancyRepository.findAll());
    }

    @Override
    public List<VacancyDto> getMyVacancies(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow();
        return vacancyMapper.toDtos(employer.getVacancies());
    }

    @Override
    public List<VacancyDto> searchVacancy(String search) {
        if(search == null || search.isEmpty()) {
            return vacancyMapper.toDtos(vacancyRepository.findAll());
        } else {
            return vacancyMapper.toDtos(vacancyRepository.searchVacancy(search));
        }
    }

    @Override
    public void setStatusOfJobSeeker(Long vacancyId, Long jobSeekerId, String status) {

    }


    @Override
    public void setStatusOfVacancy(Long id, String statusOfVacancy) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow();
        vacancy.setVacancyStatus(VacancyStatus.valueOf(statusOfVacancy));
    }


    public List<VacancyDto> getPopularPosition() {
        return vacancyMapper.toDtos(vacancyRepository.findTop5ByOrderByViewsAsc());

    }

}
