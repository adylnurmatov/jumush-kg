package kg.soft.jumushkg.service.impl;

import jakarta.transaction.Transactional;import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.domain.entity.userInfo.Position;import kg.soft.jumushkg.domain.entity.userInfo.Salary;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;import kg.soft.jumushkg.domain.enums.VacancyStatus;
import kg.soft.jumushkg.repository.EmployerRepository;import kg.soft.jumushkg.repository.PositionRepository;
import kg.soft.jumushkg.repository.SalaryRepository;import kg.soft.jumushkg.repository.VacancyRepository;
import kg.soft.jumushkg.service.VacancyService;import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;
import kg.soft.jumushkg.web.mapper.vacancy.VacancyMapper;import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;    private final EmployerRepository employerRepository;
    private final SalaryRepository salaryRepository;    private final PositionRepository positionRepository;
    @Override    @Transactional
    public VacancyDto saveVacancy(Long employerId, VacancyDto vacancyDto) {        Vacancy vacancy = new Vacancy();
        Salary salary = vacancyDto.getSalary();
        if (salary.getId() == null) {            salary = salaryRepository.save(salary);
        }        vacancy.setSalary(salary);
        vacancy.setCompanyName(vacancyDto.getCompanyName());
        vacancy.setDescription(vacancyDto.getDescription());        vacancy.setSkills(vacancyDto.getSkills());
        vacancy.setCountry(vacancyDto.getCountry());        vacancy.setCity(vacancyDto.getCity());
        vacancy.setAboutCompany(vacancyDto.getAboutCompany());        vacancy.setEmploymentType(vacancyDto.getEmploymentType());
        vacancy.setCreatedAt(LocalDateTime.now());        vacancy.setVacancyStatus(vacancyDto.getVacancyStatus());
        vacancy.setViews(vacancyDto.getViews());
        Position position = positionRepository.findById(vacancyDto.getPosition().getId())                .orElseThrow(() -> new RuntimeException("Position not found"));
        vacancy.setPosition(position);        vacancyRepository.save(vacancy);
        return vacancyDto;    }
    @Override
    public boolean delete(Long id) {        vacancyRepository.deleteById(id);
        return true;    }
    @Override
    public List<VacancyDto> getAll() {        return vacancyMapper.toDtos(vacancyRepository.findAll());
    }
    @Override    @Transactional
    public VacancyDto update(Long id, VacancyDto vacancyRequest) {        Vacancy vacancy = vacancyRepository.findById(id)
            .orElseThrow(() -> new BadCredentialsException("NOT_FOUND"));
        vacancy.setCompanyName(vacancyRequest.getCompanyName());        vacancy.setDescription(vacancyRequest.getDescription());
        vacancy.setSkills(vacancyRequest.getSkills());        vacancy.setCountry(vacancyRequest.getCountry());
        vacancy.setCity(vacancyRequest.getCity());        vacancy.setAboutCompany(vacancyRequest.getAboutCompany());
        vacancy.setEmploymentType(vacancyRequest.getEmploymentType());        vacancy.setCreatedAt(vacancyRequest.getCreatedAt());
        vacancy.setVacancyStatus(vacancyRequest.getVacancyStatus());        vacancy.setViews(vacancyRequest.getViews());
        vacancy.setRespondents(vacancyRequest.getRespondents());
        // Проверяем и сохраняем Salary, если она передана        if (vacancyRequest.getSalary() != null) {
        Salary salary = vacancyRequest.getSalary();            if (salary.getId() == null) {
            salary = salaryRepository.save(salary); // Сохраняем новый объект Salary            }
            vacancy.setSalary(salary);        }
        // Проверяем и связываем Position, если она передана
        if (vacancyRequest.getPosition() != null) {
            Position position = positionRepository.findById(vacancyRequest.getPosition().getId())
                    .orElseThrow(() -> new BadCredentialsException("Position not found"));            vacancy.setPosition(position);
        }
        // Сохраняем обновлённый объект Vacancy        vacancyRepository.save(vacancy);
        return vacancyRequest;
    }

    public List<VacancyDto> jobSeekerVacancies() {        return vacancyMapper.toDtos(vacancyRepository.findAll());
    }
    @Override
    public List<VacancyDto> getMyVacancies(Long id) {        Employer employer = employerRepository.findById(id).orElseThrow();
        return vacancyMapper.toDtos(employer.getVacancies());    }
    @Override
    public List<VacancyDto> searchVacancy(String search) {        if(search == null || search.isEmpty()) {
        return vacancyMapper.toDtos(vacancyRepository.findAll());        } else {
        return vacancyMapper.toDtos(vacancyRepository.searchVacancy(search));        }
    }
    @Override    public void setStatusOfJobSeeker(Long vacancyId, Long jobSeekerId, String status) {
    }

    @Override    public void setStatusOfVacancy(Long id, String statusOfVacancy) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow();        vacancy.setVacancyStatus(VacancyStatus.valueOf(statusOfVacancy));
    }
    public List<VacancyDto> getPopularPosition() {
        return vacancyMapper.toDtos(vacancyRepository.findTop5ByOrderByViewsAsc());
    }
}
