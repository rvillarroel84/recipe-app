package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMesureService {

    Optional<UnitOfMeasure> findUOM (String uom);

}
