package kg.soft.jumushkg.service;


import kg.soft.jumushkg.web.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategory();

    CategoryDto getCategoryById(Long id);

    CategoryDto createCategory(CategoryDto categoryDto);

    void deleteCategoryById(Long id);

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
}
