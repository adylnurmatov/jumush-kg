package kg.soft.jumushkg.web.mapper.employer;

import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.web.dto.employer.EmployerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerMapperImpl implements EmployerMapper{
    @Override
    public EmployerDto toDto(Employer employer) {
        return new EmployerDto(
                employer.getId(),
                employer.getUsername(),
                employer.getEmail(),
                employer.getPassword(),
                employer.getRole()
        );
    }

    @Override
    public List<EmployerDto> toDtos(List<Employer> employers) {
        List<EmployerDto> employerDtos = new ArrayList<>();
        for (Employer employer:employers) {
            employerDtos.add(toDto(employer));
        }
        return employerDtos;
    }
}
