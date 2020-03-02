package com.rvillarroel.recipeapp.converters;

import com.rvillarroel.recipeapp.commands.CategoryCommand;
import com.rvillarroel.recipeapp.domain.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "Description";
    public static final Long LONG_VALUE = new Long(1L);

    CategoryCommandToCategory converter;

    @BeforeEach
    public void setUp() throws Exception{
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testEmpyObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() throws Exception{

        //given
        CategoryCommand command = new CategoryCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);
        //when
        Category category = converter.convert(command);
        //then
        assertNotNull(category);
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}