package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
