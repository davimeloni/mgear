package com.mgearapp.service;

import com.mgearapp.service.dto.BikeBrakePadDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BikeBrakePad.
 */
public interface BikeBrakePadService {

    /**
     * Save a bikeBrakePad.
     *
     * @param bikeBrakePadDTO the entity to save
     * @return the persisted entity
     */
    BikeBrakePadDTO save(BikeBrakePadDTO bikeBrakePadDTO);

    /**
     * Get all the bikeBrakePads.
     *
     * @return the list of entities
     */
    List<BikeBrakePadDTO> findAll();


    /**
     * Get the "id" bikeBrakePad.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BikeBrakePadDTO> findOne(Long id);

    /**
     * Delete the "id" bikeBrakePad.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
