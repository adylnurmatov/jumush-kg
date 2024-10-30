package kg.soft.jumushkg.service;




import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;

import java.util.List;

public interface VacancyService {
    VacancyDto saveVacancy(Long id, VacancyDto vacancyDto);


    boolean delete(Long id);

    List<VacancyDto> getAll();


    VacancyDto update(Long id, VacancyDto vacancyRequest);

    List<VacancyDto> jobSeekerVacancies();
//    List<JobSeekerVacanciesResponses> findByVacancyJobSeekerVacancies(Long id);

    List<VacancyDto> getMyVacancies(Long id);


//
//    List<Vacancy> employeeVacancies();

    List<VacancyDto> searchVacancy(String search);

    List<VacancyDto> filter(String category, String position, String country, String city, String experience,
                                             String typeOfEmployments, Boolean salary, Boolean date);

    VacancyDto updateById(Long id, VacancyDto vacancyDto);

    VacancyDto updateEmployerVacancyByIds(Long employerId, Long vacancyId, VacancyDto vacancyRequest);

    void setStatusOfJobSeeker(Long vacancyId, Long jobSeekerId, String status);

    void setStatusOfVacancy(Long id, String statusOfVacancy);

    List<VacancyDto> sortedTwoVacancies(Long vacancyId);
    List<VacancyDto> employerVacanciesSearchUserId(Long userId, String search);

    List<VacancyDto> getAllVacancy(String vacancyName, String filterType);

    List<VacancyDto> getVacancyCountByCategory();

    List<VacancyDto> getPopularPosition();

    VacancyDto aboutVacancy(Long vacancyId);

    List<VacancyDto> employerVacanciesFilterUserId(Long userId, String respondedCount, String byDate, String byStatusOfVacancy);
}
