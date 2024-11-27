package kg.soft.jumushkg.repository;

import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> findTop5ByOrderByViewsAsc();

    @Query("SELECT v FROM Vacancy v WHERE v.companyName LIKE %:search% OR v.description LIKE %:search%")
    List<Vacancy> searchVacancy(@Param("search") String search);
}

