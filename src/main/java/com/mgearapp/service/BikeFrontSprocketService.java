package com.mgearapp.service;

import com.mgearapp.service.dto.BikeFrontSprocketDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BikeFrontSprocket.
 */
public interface BikeFrontSprocketService {

    /**
     * Save a bikeFrontSprocket.
     *
     * @param bikeFrontSprocketDTO the entity to save
     * @return the persisted entity
     */
    BikeFrontSprocketDTO save(BikeFrontSprocketDTO bikeFrontSprocketDTO);

    /**
     * Get all the bikeFrontSprockets.
     *
     * @return the list of entities
     */
    List<BikeFrontSprocketDTO> findAll();


    /**
     * Get the "id" bikeFrontSprocket.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BikeFrontSprocketDTO> findOne(Long id);

    /**
     * Delete the "id" bikeFrontSprocket.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
