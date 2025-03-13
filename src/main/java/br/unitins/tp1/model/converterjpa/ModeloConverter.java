package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.Modelos;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ModeloConverter implements AttributeConverter<Modelos, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Modelos modelos) {
        return modelos == null ? null : modelos.getId();

    }

    @Override
    public Modelos convertToEntityAttribute(Integer id) {
        return Modelos.valueOf(id);
    }
    
}
