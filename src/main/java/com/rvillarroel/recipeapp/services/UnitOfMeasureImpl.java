package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.domain.UnitOfMeasure;
import com.rvillarroel.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitOfMeasureImpl implements UnitOfMesureService {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public Optional<UnitOfMeasure> findUOM(String uom) {

        return unitOfMeasureRepository.findByDescription(uom);
    }
}
