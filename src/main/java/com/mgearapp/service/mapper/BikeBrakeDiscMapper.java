package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BikeBrakeDiscDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BikeBrakeDisc and its DTO BikeBrakeDiscDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BikeBrakeDiscMapper extends EntityMapper<BikeBrakeDiscDTO, BikeBrakeDisc> {


    @Mapping(target = "bikes", ignore = true)
    BikeBrakeDisc toEntity(BikeBrakeDiscDTO bikeBrakeDiscDTO);

    default BikeBrakeDisc fromId(Long id) {
        if (id == null) {
            return null;
        }
        BikeBrakeDisc bikeBrakeDisc = new BikeBrakeDisc();
        bikeBrakeDisc.setId(id);
        return bikeBrakeDisc;
    }
}
