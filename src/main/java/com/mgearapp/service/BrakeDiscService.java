package com.mgearapp.service;

import com.mgearapp.service.dto.BrakeDiscDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing BrakeDisc.
 */
public interface BrakeDiscService {

    /**
     * Save a brakeDisc.
     *
     * @param brakeDiscDTO the entity to save
     * @return the persisted entity
     */
    BrakeDiscDTO save(BrakeDiscDTO brakeDiscDTO);

    /**
     * Get all the brakeDiscs.
     *
     * @return the list of entities
     */
    List<BrakeDiscDTO> findAll();


    /**
     * Get the "id" brakeDisc.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BrakeDiscDTO> findOne(Long id);

    /**
     * Delete the "id" brakeDisc.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
