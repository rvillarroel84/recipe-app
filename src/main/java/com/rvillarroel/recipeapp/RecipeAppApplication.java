package com.rvillarroel.recipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class RecipeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeAppApplication.class, args);
    }

}
