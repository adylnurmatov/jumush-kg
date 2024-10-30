package kg.soft.jumushkg.repository;


import kg.soft.jumushkg.domain.entity.userInfo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
