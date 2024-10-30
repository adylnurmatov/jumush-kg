package kg.soft.jumushkg.web.mapper.jobSeeker;


import kg.soft.jumushkg.domain.entity.user.JobSeeker;
import kg.soft.jumushkg.web.dto.JobSeeker.JobSeekerDto;

import java.util.List;

public interface JobSeekerMapper {
    JobSeekerDto toDto(JobSeeker jobSeeker);
    List<JobSeekerDto> toDtos(List<JobSeeker> jobSeekers);
}
