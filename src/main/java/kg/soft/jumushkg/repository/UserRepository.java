package kg.soft.jumushkg.repository;


import kg.soft.jumushkg.domain.entity.user.User;
import kg.soft.jumushkg.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    void deleteByEmail(String email);
    void deleteByEmailAndPassword(String email, String password);
    List<User> findUserByRole(Role role);

}
