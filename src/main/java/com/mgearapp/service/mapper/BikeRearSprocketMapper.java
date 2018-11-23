package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BikeRearSprocketDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BikeRearSprocket and its DTO BikeRearSprocketDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BikeRearSprocketMapper extends EntityMapper<BikeRearSprocketDTO, BikeRearSprocket> {


    @Mapping(target = "bikes", ignore = true)
    BikeRearSprocket toEntity(BikeRearSprocketDTO bikeRearSprocketDTO);

    default BikeRearSprocket fromId(Long id) {
        if (id == null) {
            return null;
        }
        BikeRearSprocket bikeRearSprocket = new BikeRearSprocket();
        bikeRearSprocket.setId(id);
        return bikeRearSprocket;
    }
}
