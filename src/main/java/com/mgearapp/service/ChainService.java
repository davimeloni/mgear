package com.mgearapp.service;

import com.mgearapp.service.dto.ChainDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Chain.
 */
public interface ChainService {

    /**
     * Save a chain.
     *
     * @param chainDTO the entity to save
     * @return the persisted entity
     */
    ChainDTO save(ChainDTO chainDTO);

    /**
     * Get all the chains.
     *
     * @return the list of entities
     */
    List<ChainDTO> findAll();


    /**
     * Get the "id" chain.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<ChainDTO> findOne(Long id);

    /**
     * Delete the "id" chain.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
