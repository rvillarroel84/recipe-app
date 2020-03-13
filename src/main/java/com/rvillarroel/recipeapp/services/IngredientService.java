package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.commands.IngredientCommand;

public interface IngredientService {

    public IngredientCommand showIngredient(Long recipeId, Long ingredientId);
}
