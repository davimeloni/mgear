package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BikeFrontSprocketDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BikeFrontSprocket and its DTO BikeFrontSprocketDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BikeFrontSprocketMapper extends EntityMapper<BikeFrontSprocketDTO, BikeFrontSprocket> {


    @Mapping(target = "bikes", ignore = true)
    BikeFrontSprocket toEntity(BikeFrontSprocketDTO bikeFrontSprocketDTO);

    default BikeFrontSprocket fromId(Long id) {
        if (id == null) {
            return null;
        }
        BikeFrontSprocket bikeFrontSprocket = new BikeFrontSprocket();
        bikeFrontSprocket.setId(id);
        return bikeFrontSprocket;
    }
}
