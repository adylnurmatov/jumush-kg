package kg.soft.jumushkg.web.mapper.category;


import kg.soft.jumushkg.domain.entity.userInfo.Category;
import kg.soft.jumushkg.web.dto.category.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryMapperImpl implements CategoryMapper{
    @Override
    public CategoryDto toDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getPositions()
        );
    }

    @Override
    public List<CategoryDto> toDtos(List<Category> categories) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category:categories) {
            categoryDtos.add(toDto(category));
        }
        return categoryDtos;
    }

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setPositions(categoryDto.getPositions());
        return category;
    }
}
