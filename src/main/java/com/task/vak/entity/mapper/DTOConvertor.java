package com.task.vak.entity.mapper;
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


    public <T,D extends Convertable> D convertToEntity(T DTO, D entity){
        return modelMapper.map(DTO,(Type) entity.getClass());
    }

    public <T,D extends Convertable> T convertToDTO(D entity,T DTO){
        return modelMapper.map(entity,(Type) DTO.getClass());
    }

    public <T,D extends Convertable> D convertFromEntityToEntity(D sourceEntity,T targetEntity){
        return modelMapper.map(sourceEntity,(Type) targetEntity.getClass());
    }

}