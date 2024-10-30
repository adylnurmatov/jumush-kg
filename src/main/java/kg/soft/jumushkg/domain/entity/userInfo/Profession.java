package kg.soft.jumushkg.domain.entity.userInfo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startedWorking;
    private String skills;
    @OneToOne(cascade = CascadeType.ALL)
    private Position position;
}
