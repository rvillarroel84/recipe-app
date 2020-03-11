package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.commands.RecipeCommand;
import com.rvillarroel.recipeapp.converters.RecipeCommandToRecipe;
import com.rvillarroel.recipeapp.converters.RecipeToRecipeCommand;
import com.rvillarroel.recipeapp.domain.Recipe;
import com.rvillarroel.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("Im in the service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        //recipeSet.addAll((Collection<? extends Recipe>) recipeRepository.findAll());
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found!");
        }
        return recipeOptional.get();
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        //convierte command(Desacoplado de Hibernate) to Recipe
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        //guarda en la Base Datos
        Recipe saveRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved recipeId" + saveRecipe.getId());
        //retorna el Objeto guardado a Command
        return recipeToRecipeCommand.convert(saveRecipe);
    }

    @Override
    public void deleteRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        recipeRepository.delete(detachedRecipe);
    }


    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }




}
