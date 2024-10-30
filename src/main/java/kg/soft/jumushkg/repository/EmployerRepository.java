package kg.soft.jumushkg.repository;


import kg.soft.jumushkg.domain.entity.user.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
