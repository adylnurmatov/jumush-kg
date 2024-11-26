package kg.soft.jumushkg.domain.entity.user;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kg.soft.jumushkg.domain.entity.userInfo.Image;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import kg.soft.jumushkg.domain.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "employer")
public class Employer extends User{
    @OneToMany
    private List<Vacancy> vacancies;
    @OneToOne
    private Image logo;
    private String address;
    private String country;
    private String city;
    private String about;
    private String phoneNumber;

    public Employer(String username, String email, String password, Role role) {
        super(username, email, password, role);
    }

    public Employer() {

    }
}
