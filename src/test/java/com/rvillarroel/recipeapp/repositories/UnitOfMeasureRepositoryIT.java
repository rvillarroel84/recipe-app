package com.rvillarroel.recipeapp.repositories;

//import com.rvillarroel.recipeapp.datasource.H2JpaConfig;
import com.rvillarroel.recipeapp.domain.UnitOfMeasures;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
@ActiveProfiles("test")
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