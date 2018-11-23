package com.mgearapp.service;

import com.mgearapp.service.dto.BrakePadDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BrakePad.
 */
public interface BrakePadService {

    /**
     * Save a brakePad.
     *
     * @param brakePadDTO the entity to save
     * @return the persisted entity
     */
    BrakePadDTO save(BrakePadDTO brakePadDTO);

    /**
     * Get all the brakePads.
     *
     * @return the list of entities
     */
    List<BrakePadDTO> findAll();


    /**
     * Get the "id" brakePad.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BrakePadDTO> findOne(Long id);

    /**
     * Delete the "id" brakePad.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
