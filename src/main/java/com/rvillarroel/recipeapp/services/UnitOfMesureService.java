package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.commands.UnitOfMeasureCommand;
import com.rvillarroel.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;
import java.util.Set;

public interface UnitOfMesureService {

    Optional<UnitOfMeasure> findUOM (String uom);
    Set<UnitOfMeasureCommand> listAllUoms();

}
