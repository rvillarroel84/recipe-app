package com.rvillarroel.recipeapp.repositories;

import com.rvillarroel.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
