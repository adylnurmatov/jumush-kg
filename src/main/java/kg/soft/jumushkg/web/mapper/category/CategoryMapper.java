package kg.soft.jumushkg.web.mapper.category;


import kg.soft.jumushkg.domain.entity.userInfo.Category;
import kg.soft.jumushkg.web.dto.category.CategoryDto;

import java.util.List;

public interface CategoryMapper {
    CategoryDto toDto(Category category);
    List<CategoryDto> toDtos(List<Category> categories);
    Category toEntity(CategoryDto categoryDto);
}
