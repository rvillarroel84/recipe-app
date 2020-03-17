package com.rvillarroel.recipeapp.converters;

import com.rvillarroel.recipeapp.commands.UnitOfMeasureCommand;
import com.rvillarroel.recipeapp.domain.UnitOfMeasures;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasures>{

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasures convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMeasures uom = new UnitOfMeasures();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
