package kg.soft.jumushkg.repository;


import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
