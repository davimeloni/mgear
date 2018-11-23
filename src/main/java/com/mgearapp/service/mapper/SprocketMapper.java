package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.SprocketDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Sprocket and its DTO SprocketDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SprocketMapper extends EntityMapper<SprocketDTO, Sprocket> {



    default Sprocket fromId(Long id) {
        if (id == null) {
            return null;
        }
        Sprocket sprocket = new Sprocket();
        sprocket.setId(id);
        return sprocket;
    }
}
