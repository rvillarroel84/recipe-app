package com.rvillarroel.recipeapp.repositories;

import com.rvillarroel.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
