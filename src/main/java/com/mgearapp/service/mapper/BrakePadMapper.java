package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.BrakePadDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BrakePad and its DTO BrakePadDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BrakePadMapper extends EntityMapper<BrakePadDTO, BrakePad> {



    default BrakePad fromId(Long id) {
        if (id == null) {
            return null;
        }
        BrakePad brakePad = new BrakePad();
        brakePad.setId(id);
        return brakePad;
    }
}
