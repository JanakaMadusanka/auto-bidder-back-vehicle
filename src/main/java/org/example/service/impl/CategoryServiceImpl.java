package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.CategoryDto;
import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository repository;
    final ModelMapper mapper;

    @Override
    public void addCategory(CategoryDto categoryDto) {

        // Check if a category with the same name already exists
        if (repository.findByCategory(categoryDto.getCategory()) != null) {
            throw new IllegalArgumentException("Category with the name '" + categoryDto.getCategory() + "' already exists.");
        }

        // Map the DTO to the entity and set the creation date
        CategoryEntity entity = mapper.map(categoryDto, CategoryEntity.class);
        entity.setCreatedDate(LocalDateTime.now());  // Automatically set the creation date

        // Save the new category
        repository.save(entity);
    }

    @Override
    public boolean updateCategory(CategoryDto categoryDto) {
        Short categoryId = categoryDto.getId();
        if (categoryId != null){
            CategoryEntity existingUser = repository.findById(categoryId).orElse(null);
            if(existingUser !=null){

                // Map the DTO to the entity and set the creation date
                CategoryEntity entity = mapper.map(categoryDto, CategoryEntity.class);
                entity.setCreatedDate(LocalDateTime.now());  // Automatically set the creation date

                // Save the new category
                repository.save(entity);
                return true;

            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Short id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryEntity> entityList = (List<CategoryEntity>) repository.findAll();
        List<CategoryDto> userList = new ArrayList<>();

        for(CategoryEntity entity : entityList){
            userList.add(mapper.map(entity,CategoryDto.class));
        }
        return userList;
    }

    @Override
    public CategoryDto searchCategoryById(Short id) {
        return mapper.map(repository.findById(id),CategoryDto.class);
    }

    @Override
    public CategoryDto searchCategoryByName(String category) {
        return mapper.map(repository.findByCategory(category),CategoryDto.class);
    }
}
