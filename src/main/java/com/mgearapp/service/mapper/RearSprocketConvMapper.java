package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.RearSprocketConvDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RearSprocketConv and its DTO RearSprocketConvDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RearSprocketConvMapper extends EntityMapper<RearSprocketConvDTO, RearSprocketConv> {


    @Mapping(target = "bikes", ignore = true)
    RearSprocketConv toEntity(RearSprocketConvDTO rearSprocketConvDTO);

    default RearSprocketConv fromId(Long id) {
        if (id == null) {
            return null;
        }
        RearSprocketConv rearSprocketConv = new RearSprocketConv();
        rearSprocketConv.setId(id);
        return rearSprocketConv;
    }
}
