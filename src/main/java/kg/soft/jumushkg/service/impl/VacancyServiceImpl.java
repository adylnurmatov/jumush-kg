package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.repository.VacancyRepository;
import kg.soft.jumushkg.service.VacancyService;
import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;
import kg.soft.jumushkg.web.mapper.vacancy.VacancyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {
    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;
    @Override
    public VacancyDto saveVacancy(Long id, VacancyDto vacancyDto) {
        return null;
    }
    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<VacancyDto> getAll() {
        return null;
    }

    @Override
    public VacancyDto update(Long id, VacancyDto vacancyRequest) {
        return null;
    }

    @Override
    public List<VacancyDto> jobSeekerVacancies() {
        return null;
    }

    @Override
    public List<VacancyDto> getMyVacancies(Long id) {
        return null;
    }

    @Override
    public List<VacancyDto> searchVacancy(String search) {
        return null;
    }

    @Override
    public List<VacancyDto> filter(String category, String position, String country, String city, String experience, String typeOfEmployments, Boolean salary, Boolean date) {
        return null;
    }

    @Override
    public VacancyDto updateById(Long id, VacancyDto vacancyDto) {
        return null;
    }

    @Override
    public VacancyDto updateEmployerVacancyByIds(Long employerId, Long vacancyId, VacancyDto vacancyRequest) {
        return null;
    }

    @Override
    public void setStatusOfJobSeeker(Long vacancyId, Long jobSeekerId, String status) {

    }

    @Override
    public void setStatusOfVacancy(Long id, String statusOfVacancy) {

    }

    @Override
    public List<VacancyDto> sortedTwoVacancies(Long vacancyId) {
        return null;
    }

    @Override
    public List<VacancyDto> employerVacanciesSearchUserId(Long userId, String search) {
        return null;
    }

    @Override
    public List<VacancyDto> getAllVacancy(String vacancyName, String filterType) {
        return null;
    }

    @Override
    public List<VacancyDto> getVacancyCountByCategory() {
        return null;
    }

    @Override
    public List<VacancyDto> getPopularPosition() {
        return vacancyMapper.toDtos(vacancyRepository.findTop5ByOrderByViewsAsc());

    }

    @Override
    public VacancyDto aboutVacancy(Long vacancyId) {
        return null;
    }

    @Override
    public List<VacancyDto> employerVacanciesFilterUserId(Long userId, String respondedCount, String byDate, String byStatusOfVacancy) {
        return null;
    }
}
