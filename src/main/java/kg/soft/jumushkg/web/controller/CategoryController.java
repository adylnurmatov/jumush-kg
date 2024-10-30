package kg.soft.jumushkg.web.controller;


import kg.soft.jumushkg.service.CategoryService;
import kg.soft.jumushkg.web.dto.category.CategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories1() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/get/category/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("delete/category/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }

    @PostMapping("/update/category/{id}")
    public CategoryDto updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryRequest) {
        return categoryService.updateCategory(id, categoryRequest);
    }


    @PostMapping("/create/category")
    public void createCategory(@RequestBody CategoryDto categoryRequest) {
        categoryService.createCategory(categoryRequest);
    }
}
