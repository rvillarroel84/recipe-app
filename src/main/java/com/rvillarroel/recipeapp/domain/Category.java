package com.rvillarroel.recipeapp.domain;

import javax.persistence.*;
import java.util.Set;

@lombok.Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
