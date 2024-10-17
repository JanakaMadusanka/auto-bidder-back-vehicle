package org.example.service;

import org.example.dto.CategoryDto;
import java.util.List;
public interface CategoryService {
    void addCategory(CategoryDto categoryDto);
    boolean updateCategory(CategoryDto categoryDto);
    boolean deleteCategory(Short id);
    List<CategoryDto> getAllCategory();
    CategoryDto searchCategoryById(Short id);
    CategoryDto searchCategoryByName(String category);
}
