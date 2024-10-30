package kg.soft.jumushkg.web.dto.category;


import jakarta.validation.constraints.NotNull;
import kg.soft.jumushkg.domain.entity.userInfo.Position;
import kg.soft.jumushkg.web.dto.validation.OnCreate;
import kg.soft.jumushkg.web.dto.validation.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {
    @NotNull(message = "id cannot be null", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "name cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String name;
    @NotNull(message = "name cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private List<Position> positions;
}
