package com.mgearapp.service;

import com.mgearapp.service.dto.SprocketDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Sprocket.
 */
public interface SprocketService {

    /**
     * Save a sprocket.
     *
     * @param sprocketDTO the entity to save
     * @return the persisted entity
     */
    SprocketDTO save(SprocketDTO sprocketDTO);

    /**
     * Get all the sprockets.
     *
     * @return the list of entities
     */
    List<SprocketDTO> findAll();


    /**
     * Get the "id" sprocket.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<SprocketDTO> findOne(Long id);

    /**
     * Delete the "id" sprocket.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
