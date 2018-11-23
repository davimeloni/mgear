package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BrakeDiscDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BrakeDisc and its DTO BrakeDiscDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BrakeDiscMapper extends EntityMapper<BrakeDiscDTO, BrakeDisc> {



    default BrakeDisc fromId(Long id) {
        if (id == null) {
            return null;
        }
        BrakeDisc brakeDisc = new BrakeDisc();
        brakeDisc.setId(id);
        return brakeDisc;
    }
}
