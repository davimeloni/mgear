package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BikeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Bike and its DTO BikeDTO.
 */
@Mapper(componentModel = "spring", uses = {BikeFrontSprocketMapper.class, BikeRearSprocketMapper.class, RearSprocketConvMapper.class, FrontSprocketConvMapper.class, ChainMapper.class, BikeBrakePadMapper.class, BikeBrakeDiscMapper.class})
public interface BikeMapper extends EntityMapper<BikeDTO, Bike> {



    default Bike fromId(Long id) {
        if (id == null) {
            return null;
        }
        Bike bike = new Bike();
        bike.setId(id);
        return bike;
    }
}
