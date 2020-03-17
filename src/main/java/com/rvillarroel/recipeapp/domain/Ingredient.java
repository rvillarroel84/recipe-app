package com.rvillarroel.recipeapp.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne(fetch = FetchType.EAGER) //retrive form de DataBase.
    private UnitOfMeasures uom;

    public Ingredient() {
    }

    public Ingredient(Long id) {
        this.id = id;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasures unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.uom = unitOfMeasure;
    }
}
