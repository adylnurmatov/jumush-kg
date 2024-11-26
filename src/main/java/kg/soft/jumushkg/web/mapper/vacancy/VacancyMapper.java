package kg.soft.jumushkg.web.mapper.vacancy;



import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import kg.soft.jumushkg.web.dto.vacancy.VacancyDto;

import java.util.List;

public interface VacancyMapper {
    VacancyDto toDto(Vacancy vacancy);
    List<VacancyDto> toDtos(List<Vacancy> vacancies);
    Vacancy toEntity(VacancyDto vacancyDto);
}
