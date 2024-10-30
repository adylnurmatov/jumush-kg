package kg.soft.jumushkg.web.mapper.employer;


import kg.soft.jumushkg.domain.entity.user.Employer;
import kg.soft.jumushkg.web.dto.employer.EmployerDto;

import java.util.List;

public interface EmployerMapper {
    EmployerDto toDto(Employer employer);
    List<EmployerDto> toDtos(List<Employer> employers);

}
