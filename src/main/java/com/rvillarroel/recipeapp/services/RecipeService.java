package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.commands.RecipeCommand;
import com.rvillarroel.recipeapp.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    void deleteById(Long id);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteRecipeCommand(RecipeCommand command);
}
