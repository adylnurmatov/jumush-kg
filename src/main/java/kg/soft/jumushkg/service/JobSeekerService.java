package kg.soft.jumushkg.service;


import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.domain.entity.userInfo.Position;
import kg.soft.jumushkg.web.dto.JobSeeker.JobSeekerDto;
import kg.soft.jumushkg.web.dto.user.UserDto;

import java.util.List;

public interface JobSeekerService {

    List<JobSeekerDto> findByName(String name);


//    FileResponse uploadResume(MultipartFile file, Long id);


    List<JobSeekerDto> getAllJobSeekers();


    JobSeekerDto update(Long id, JobSeekerDto jobSeeker);

    JobSeekerDto getById(Long id);

    List<JobSeekerDto> filter(Position position,
                              Education education,
                              String country,
                              String city,
                              String experienceName);



    List<JobSeekerDto> searchByFirstAndLastName(
            String firstname,
            String lastname
    );

    List<Position> getAllPositions();


    JobSeekerDto create(UserDto jobSeekerDto);
}
