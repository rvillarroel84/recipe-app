package com.rvillarroel.recipeapp.controllers;

import com.rvillarroel.recipeapp.domain.Category;
import com.rvillarroel.recipeapp.domain.UnitOfMeasure;
import com.rvillarroel.recipeapp.repositories.CategoryRepository;
import com.rvillarroel.recipeapp.repositories.UnitOfMeasureRepository;
import com.rvillarroel.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.Optional;

@Controller
public class IndexController {

//    private CategoryRepository categoryRepository;
//    private UnitOfMeasureRepository unitOfMeasureRepository;
//
//    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//    }
    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("Teaspoon");

//        System.out.println("Category Id is: " + categoryOptional.get().getId());
//        System.out.println("Uom Id is: " + unitOfMeasure.get().getId());
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
    @RequestMapping({"/recipe", "/recipe.html"})
    public String getRecipe(Model model){
        model.addAttribute("recipe", recipeService.getRecipe(1L));
        return "recipe";
    }

}
