package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.commands.IngredientCommand;
import com.rvillarroel.recipeapp.domain.Ingredient;

public interface IngredientService {

    public IngredientCommand showIngredient(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
}
