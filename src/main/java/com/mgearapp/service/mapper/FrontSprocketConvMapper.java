package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.FrontSprocketConvDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity FrontSprocketConv and its DTO FrontSprocketConvDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FrontSprocketConvMapper extends EntityMapper<FrontSprocketConvDTO, FrontSprocketConv> {


    @Mapping(target = "bikes", ignore = true)
    FrontSprocketConv toEntity(FrontSprocketConvDTO frontSprocketConvDTO);

    default FrontSprocketConv fromId(Long id) {
        if (id == null) {
            return null;
        }
        FrontSprocketConv frontSprocketConv = new FrontSprocketConv();
        frontSprocketConv.setId(id);
        return frontSprocketConv;
    }
}
