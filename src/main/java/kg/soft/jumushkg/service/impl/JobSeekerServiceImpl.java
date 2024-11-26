package kg.soft.jumushkg.service.impl;


import kg.soft.jumushkg.domain.entity.user.JobSeeker;
import kg.soft.jumushkg.domain.entity.userInfo.Education;
import kg.soft.jumushkg.domain.entity.userInfo.Image;
import kg.soft.jumushkg.domain.entity.userInfo.Position;
import kg.soft.jumushkg.domain.exception.ResourceNotFoundException;
import kg.soft.jumushkg.repository.JobSeekerRepository;
import kg.soft.jumushkg.repository.PositionRepository;
import kg.soft.jumushkg.service.JobSeekerService;
import kg.soft.jumushkg.web.dto.JobSeeker.JobSeekerDto;
import kg.soft.jumushkg.web.dto.user.UserDto;
import kg.soft.jumushkg.web.mapper.jobSeeker.JobSeekerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSeekerServiceImpl implements JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;
    private final JobSeekerMapper jobSeekerMapper;
    private final PositionRepository positionRepository;

    @Override
    public List<JobSeekerDto> findByName(String name) {
        return jobSeekerMapper.toDtos(jobSeekerRepository.findAllByUsername(name));
    }



    @Override
    public List<JobSeekerDto> getAllJobSeekers() {
        return jobSeekerMapper.toDtos(jobSeekerRepository.findAll());
    }


    @Override
    public JobSeekerDto update(Long id, JobSeekerDto jobSeekerDto) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        jobSeeker.setUsername(jobSeekerDto.getUsername());
        jobSeeker.setEmail(jobSeekerDto.getEmail());
        jobSeeker.setRole(jobSeekerDto.getRole());
        jobSeeker.setPassword(jobSeekerDto.getPassword());
        return jobSeekerDto;
    }

    @Override
    public JobSeekerDto getById(Long id) {
        return jobSeekerMapper.toDto(jobSeekerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NOT_FOUND")));
    }
    @Override
    public List<JobSeekerDto> filter(
            Position position,
            Education education,
            String country,
            String city,
            String experienceName
    ) {
        if (position == null && (country == null || country.isEmpty()) &&
                (city == null || city.isEmpty()) && (experienceName == null || experienceName.isEmpty()) &&
                education == null) {
            return jobSeekerMapper.toDtos(jobSeekerRepository.findAll());
        }

        return jobSeekerMapper.toDtos(jobSeekerRepository.filterJobSeekers(
                position != null ? position.getName() : null,
                education,
                country != null && !country.isEmpty() ? country : null,
                city != null && !city.isEmpty() ? city : null,
                experienceName
        ));
    }


    @Override
    public List<JobSeekerDto> searchByFirstAndLastName(String firstname, String lastname) {
        return jobSeekerMapper.toDtos(jobSeekerRepository.searchJobSeekers(
                firstname != null && !firstname.isEmpty() ? firstname : null,
                lastname != null && !lastname.isEmpty() ? lastname : null

        ));
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    @Override
    public JobSeekerDto create(UserDto jobSeekerDto) {
        JobSeeker jobSeeker = new JobSeeker();
        String name = jobSeeker.getUsername();
        return null;
    }


    private Image toImageEntity(MultipartFile file1) throws IOException {
        Image image = new Image();
        image.setName(file1.getName());
        image.setContentType(file1.getContentType());
        image.setOriginalFileName(file1.getOriginalFilename());
        image.setSize(file1.getSize());
        image.setBytes(file1.getBytes());
        return image;

    }

    public void addAvatar(MultipartFile file, Long userId) {
        if(file.getSize() != 0) {
            Image image = new Image();
            try {
                image = toImageEntity(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JobSeeker user = jobSeekerRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
            user.setProfilePicture(image);
        }
    }
}
