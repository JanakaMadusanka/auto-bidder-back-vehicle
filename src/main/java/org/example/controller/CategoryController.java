package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CategoryDto;
import org.example.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    final CategoryService service;
    @PostMapping("/register")
    public ResponseEntity<String> registerCategory(@RequestBody CategoryDto categoryDto) {
        try {
            service.addCategory(categoryDto);
            return new ResponseEntity<>("Category registered successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable Short id, @RequestBody CategoryDto categoryDto){
        categoryDto.setId(id);
        if(service.updateCategory(categoryDto)){
            return "Updated";
        }
        return "Category doesn't exist";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Short id) {
        if (service.deleteCategory(id)) {
            return "Deleted";
        }
        return "Category doesn't exist";
    }

    @GetMapping("/get/all")
    public List<CategoryDto> getAllCategory(){
        return service.getAllCategory();
    }

    @GetMapping("/search-by-id/{id}")
    public CategoryDto searchUserCategoryById(@PathVariable Short id){
            return service.searchCategoryById(id);
    }
    @GetMapping("/search-by-name/{category}")
    public CategoryDto searchUserCategoryByName(@PathVariable String category){
        return service.searchCategoryByName(category);
    }
}
