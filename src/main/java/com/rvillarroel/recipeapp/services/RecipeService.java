package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Optional<Recipe> getRecipe(Long id);
}
