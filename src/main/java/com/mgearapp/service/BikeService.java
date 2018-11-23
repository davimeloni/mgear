package com.mgearapp.service;

import com.mgearapp.service.dto.BikeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Bike.
 */
public interface BikeService {

    /**
     * Save a bike.
     *
     * @param bikeDTO the entity to save
     * @return the persisted entity
     */
    BikeDTO save(BikeDTO bikeDTO);

    /**
     * Get all the bikes.
     *
     * @return the list of entities
     */
    List<BikeDTO> findAll();

    /**
     * Get all the Bike with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    Page<BikeDTO> findAllWithEagerRelationships(Pageable pageable);
    
    /**
     * Get the "id" bike.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BikeDTO> findOne(Long id);

    /**
     * Delete the "id" bike.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
