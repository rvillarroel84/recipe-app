package com.rvillarroel.recipeapp.repositories;

import com.rvillarroel.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*@RunWith(SpringRunner.class)*/
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    void findByUom() {

        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByUom("Each");
        assertEquals("Each", unitOfMeasure.get().getUom());
    }
}