package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.domain.Recipe;
import com.rvillarroel.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        //recipeSet.addAll((Collection<? extends Recipe>) recipeRepository.findAll());
        return recipeSet;
    }

    @Override
    public Optional<Recipe> getRecipe(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe;
    }

}
