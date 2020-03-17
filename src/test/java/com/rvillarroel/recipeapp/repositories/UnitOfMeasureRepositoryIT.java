package com.rvillarroel.recipeapp.repositories;

import com.rvillarroel.recipeapp.domain.UnitOfMeasures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/*@RunWith(SpringRunner.class)*/
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    void findByUom() {

        Optional<UnitOfMeasures> unitOfMeasure = unitOfMeasureRepository.findByDescription("Each");
        assertEquals("Each", unitOfMeasure.get().getDescription());
    }
}