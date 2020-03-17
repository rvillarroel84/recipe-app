package com.rvillarroel.recipeapp.services;

import com.rvillarroel.recipeapp.commands.UnitOfMeasureCommand;
import com.rvillarroel.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.rvillarroel.recipeapp.domain.UnitOfMeasures;
import com.rvillarroel.recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnitOfMeasureImplTest {


    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMesureService service;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new UnitOfMeasureImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    void listAllUoms() throws Exception{
        //given
        Set<UnitOfMeasures> unitOfMeasures = new HashSet<>();
        UnitOfMeasures uom1 = new UnitOfMeasures();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasures uom2 = new UnitOfMeasures();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        //when
        Set<UnitOfMeasureCommand> commands = service.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }

}