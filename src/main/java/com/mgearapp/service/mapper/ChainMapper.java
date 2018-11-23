package com.mgearapp.service.mapper;

import com.mgearapp.domain.*;
import com.mgearapp.service.dto.ChainDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Chain and its DTO ChainDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ChainMapper extends EntityMapper<ChainDTO, Chain> {


    @Mapping(target = "bikes", ignore = true)
    Chain toEntity(ChainDTO chainDTO);

    default Chain fromId(Long id) {
        if (id == null) {
            return null;
        }
        Chain chain = new Chain();
        chain.setId(id);
        return chain;
    }
}
