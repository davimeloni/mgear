package com.mgearapp.service;

import com.mgearapp.service.dto.BikeBrakeDiscDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BikeBrakeDisc.
 */
public interface BikeBrakeDiscService {

    /**
     * Save a bikeBrakeDisc.
     *
     * @param bikeBrakeDiscDTO the entity to save
     * @return the persisted entity
     */
    BikeBrakeDiscDTO save(BikeBrakeDiscDTO bikeBrakeDiscDTO);

    /**
     * Get all the bikeBrakeDiscs.
     *
     * @return the list of entities
     */
    List<BikeBrakeDiscDTO> findAll();


    /**
     * Get the "id" bikeBrakeDisc.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BikeBrakeDiscDTO> findOne(Long id);

    /**
     * Delete the "id" bikeBrakeDisc.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
