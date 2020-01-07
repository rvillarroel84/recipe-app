package com.rvillarroel.recipeapp.domain;

import javax.persistence.*;

@lombok.Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob //Large Object
    private String recipeNote;

}
