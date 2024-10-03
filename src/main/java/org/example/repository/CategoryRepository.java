package org.example.repository;

import org.example.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity,Short> {
    CategoryEntity findByCategory(String category);
}
