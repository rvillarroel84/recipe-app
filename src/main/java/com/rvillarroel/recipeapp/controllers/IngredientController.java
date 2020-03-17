package com.rvillarroel.recipeapp.controllers;

import com.rvillarroel.recipeapp.commands.IngredientCommand;
import com.rvillarroel.recipeapp.services.IngredientService;
import com.rvillarroel.recipeapp.services.RecipeService;
import com.rvillarroel.recipeapp.services.UnitOfMesureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMesureService unitOfMesureService;


    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMesureService unitOfMesureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMesureService = unitOfMesureService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model){
      log.debug("Getting Ingredient List id" + recipeId);

      model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));

      return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.showIngredient(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

    //update Ingredient

    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId,
                                         @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.showIngredient(Long.valueOf(recipeId), Long.valueOf(id)));

        model.addAttribute("uomList", unitOfMesureService.listAllUoms());
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand command){
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        log.debug("saved receipe id:" + savedCommand.getRecipeId());
        log.debug("saved ingredient id:" + savedCommand.getId());

        return "redirect:/recipe/" + savedCommand.getRecipeId() + "/ingredient/" + savedCommand.getId() + "/show";
    }
}
