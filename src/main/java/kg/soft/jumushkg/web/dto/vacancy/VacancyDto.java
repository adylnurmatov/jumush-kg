package kg.soft.jumushkg.web.dto.vacancy;


import kg.soft.jumushkg.domain.entity.user.JobSeeker;
import kg.soft.jumushkg.domain.entity.userInfo.Position;
import kg.soft.jumushkg.domain.entity.userInfo.Salary;
import kg.soft.jumushkg.domain.enums.EmploymentType;
import kg.soft.jumushkg.domain.enums.VacancyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VacancyDto {
    private Long id;
    private String companyName;
    private String description;
    private String skills;
    private String country;
    private String city;
    private String aboutCompany;
    private EmploymentType employmentType;
    private LocalDateTime createdAt;
    private VacancyStatus vacancyStatus;
    private Salary salary;
    private Integer views;
    private List<JobSeeker> respondents;
    private Position position;
}
