package com.mgearapp.service;

import com.mgearapp.service.dto.RearSprocketConvDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing RearSprocketConv.
 */
public interface RearSprocketConvService {

    /**
     * Save a rearSprocketConv.
     *
     * @param rearSprocketConvDTO the entity to save
     * @return the persisted entity
     */
    RearSprocketConvDTO save(RearSprocketConvDTO rearSprocketConvDTO);

    /**
     * Get all the rearSprocketConvs.
     *
     * @return the list of entities
     */
    List<RearSprocketConvDTO> findAll();


    /**
     * Get the "id" rearSprocketConv.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<RearSprocketConvDTO> findOne(Long id);

    /**
     * Delete the "id" rearSprocketConv.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
