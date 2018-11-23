package com.mgearapp.service;

import com.mgearapp.service.dto.FrontSprocketConvDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing FrontSprocketConv.
 */
public interface FrontSprocketConvService {

    /**
     * Save a frontSprocketConv.
     *
     * @param frontSprocketConvDTO the entity to save
     * @return the persisted entity
     */
    FrontSprocketConvDTO save(FrontSprocketConvDTO frontSprocketConvDTO);

    /**
     * Get all the frontSprocketConvs.
     *
     * @return the list of entities
     */
    List<FrontSprocketConvDTO> findAll();


    /**
     * Get the "id" frontSprocketConv.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<FrontSprocketConvDTO> findOne(Long id);

    /**
     * Delete the "id" frontSprocketConv.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
