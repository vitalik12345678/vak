package com.task.vak.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class DTOConvertor {

    private final ModelMapper modelMapper;

    @Autowired
    public DTOConvertor(ModelMapper dtoConvertor) {
        modelMapper = dtoConvertor;
    }

    public <T, D extends Convertable> D convertToEntity(T DTO, Type entity) {
        return modelMapper.map(DTO, entity);
    }

    public <T, D extends Convertable> T convertToDTO(D entity, Type DTO) {
        return modelMapper.map(entity, DTO);
    }

}