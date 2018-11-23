package com.mgearapp.service;

import com.mgearapp.service.dto.BikeRearSprocketDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BikeRearSprocket.
 */
public interface BikeRearSprocketService {

    /**
     * Save a bikeRearSprocket.
     *
     * @param bikeRearSprocketDTO the entity to save
     * @return the persisted entity
     */
    BikeRearSprocketDTO save(BikeRearSprocketDTO bikeRearSprocketDTO);

    /**
     * Get all the bikeRearSprockets.
     *
     * @return the list of entities
     */
    List<BikeRearSprocketDTO> findAll();


    /**
     * Get the "id" bikeRearSprocket.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BikeRearSprocketDTO> findOne(Long id);

    /**
     * Delete the "id" bikeRearSprocket.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
