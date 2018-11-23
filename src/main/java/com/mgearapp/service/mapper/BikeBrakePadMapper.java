package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BikeBrakePadDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BikeBrakePad and its DTO BikeBrakePadDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BikeBrakePadMapper extends EntityMapper<BikeBrakePadDTO, BikeBrakePad> {


    @Mapping(target = "bikes", ignore = true)
    BikeBrakePad toEntity(BikeBrakePadDTO bikeBrakePadDTO);

    default BikeBrakePad fromId(Long id) {
        if (id == null) {
            return null;
        }
        BikeBrakePad bikeBrakePad = new BikeBrakePad();
        bikeBrakePad.setId(id);
        return bikeBrakePad;
    }
}
