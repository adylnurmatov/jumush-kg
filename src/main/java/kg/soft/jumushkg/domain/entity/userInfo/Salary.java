package kg.soft.jumushkg.domain.entity.userInfo;



import jakarta.persistence.*;
import kg.soft.jumushkg.domain.enums.SalaryType;
import kg.soft.jumushkg.domain.enums.Valute;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private SalaryType salaryType;
    private Double total;
    @Enumerated(EnumType.STRING)
    private Valute valute;
}
