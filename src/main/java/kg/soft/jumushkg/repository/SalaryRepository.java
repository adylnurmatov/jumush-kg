package kg.soft.jumushkg.repository;

import kg.soft.jumushkg.domain.entity.userInfo.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
