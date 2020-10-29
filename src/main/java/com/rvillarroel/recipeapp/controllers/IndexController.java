package com.rvillarroel.recipeapp.controllers;

import com.rvillarroel.recipeapp.services.RecipeService;
import com.rvillarroel.recipeapp.services.UnitOfMesureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
    private UnitOfMesureService unitOfMesureService;

    public IndexController(RecipeService recipeService, UnitOfMesureService unitOfMesureService) {

        this.unitOfMesureService = unitOfMesureService;
        this.recipeService = recipeService;
        log.debug("IndexController");
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
        model.addAttribute("recipe", recipeService.findById(1L));
        return "recipe";
    }

    @RequestMapping({"/uom", "/uom.html"})
    public String getUom(Model model){
        model.addAttribute("uom", unitOfMesureService.findUOM("Each"));
        return "uom";
    }

}
