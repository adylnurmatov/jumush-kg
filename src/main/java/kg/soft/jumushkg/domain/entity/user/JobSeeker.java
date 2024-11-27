package kg.soft.jumushkg.domain.entity.user;


import jakarta.persistence.*;
import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.domain.entity.userInfo.Image;
import kg.soft.jumushkg.domain.entity.userInfo.Profession;
import kg.soft.jumushkg.domain.entity.userInfo.Vacancy;
import kg.soft.jumushkg.domain.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "job_seeker")

public class JobSeeker extends User {
    private LocalDateTime birthday;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_picture_id")
    private Image profilePicture;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    private Image resume;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "job_seeker_vacancy",
            joinColumns = @JoinColumn(name = "job_seeker_id"),
            inverseJoinColumns = @JoinColumn(name = "vacancy_id")
    )
    private List<Vacancy> vacancies;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "education_id")
    private Education education;

    private String address;
    private String country;
    private String city;
    private String about;
    private String phoneNumber;

    public JobSeeker(String username, String email, String password, Role role) {
        super(username, email, password, role);
    }

    public JobSeeker() {

    }
}

