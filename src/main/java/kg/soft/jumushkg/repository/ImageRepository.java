package kg.soft.jumushkg.repository;


import kg.soft.jumushkg.domain.entity.userInfo.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
