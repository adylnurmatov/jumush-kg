package kg.soft.jumushkg.domain.entity.user;


import jakarta.persistence.*;
import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.domain.entity.userInfo.Image;
import kg.soft.jumushkg.domain.entity.userInfo.Profession;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User{
    private LocalDateTime birthday;
    @OneToOne(cascade = CascadeType.ALL)
    private Profession profession;
    @OneToOne(cascade = CascadeType.ALL)
    private Image profilePicture;
    @OneToOne(cascade = CascadeType.ALL)
    private Image resume;
    @ManyToMany
    private List<Vacancy> vacancies;
    @OneToOne(cascade = CascadeType.ALL)
    private Education education;
    private String address;
    private String country;
    private String city;
    private String about;
    private String phoneNumber;
}
