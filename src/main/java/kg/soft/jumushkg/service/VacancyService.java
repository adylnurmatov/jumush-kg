package kg.soft.jumushkg.service;




import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;

import java.util.List;

public interface VacancyService {
    VacancyDto saveVacancy(Long id, VacancyDto vacancyDto);


    boolean delete(Long id);

    List<VacancyDto> getAll();


    VacancyDto update(Long id, VacancyDto vacancyRequest);


    List<VacancyDto> getMyVacancies(Long id);


    List<VacancyDto> searchVacancy(String search);


    void setStatusOfJobSeeker(Long vacancyId, Long jobSeekerId, String status);

    void setStatusOfVacancy(Long id, String statusOfVacancy);

}
