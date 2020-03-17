package com.rvillarroel.recipeapp.repositories;

import com.rvillarroel.recipeapp.domain.UnitOfMeasures;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasures, Long> {

    Optional<UnitOfMeasures> findByDescription(String description);
}
