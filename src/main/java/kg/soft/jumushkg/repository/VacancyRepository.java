package kg.soft.jumushkg.repository;

import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findTop5ByOrderByViewsAsc();

    List<Vacancy> searchVacancy(String search);
}
