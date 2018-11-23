package com.mgearapp.service.impl;

import com.mgearapp.service.BikeService;
import com.mgearapp.domain.Bike;
import com.mgearapp.repository.BikeRepository;
import com.mgearapp.service.dto.BikeDTO;
import com.mgearapp.service.mapper.BikeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Bike.
 */
@Service
@Transactional
public class BikeServiceImpl implements BikeService {

    private final Logger log = LoggerFactory.getLogger(BikeServiceImpl.class);

    private final BikeRepository bikeRepository;

    private final BikeMapper bikeMapper;

    public BikeServiceImpl(BikeRepository bikeRepository, BikeMapper bikeMapper) {
        this.bikeRepository = bikeRepository;
        this.bikeMapper = bikeMapper;
    }

    /**
     * Save a bike.
     *
     * @param bikeDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BikeDTO save(BikeDTO bikeDTO) {
        log.debug("Request to save Bike : {}", bikeDTO);

        Bike bike = bikeMapper.toEntity(bikeDTO);
        bike = bikeRepository.save(bike);
        return bikeMapper.toDto(bike);
    }

    /**
     * Get all the bikes.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BikeDTO> findAll() {
        log.debug("Request to get all Bikes");
        return bikeRepository.findAllWithEagerRelationships().stream()
            .map(bikeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get all the Bike with eager load of many-to-many relationships.
     *
     * @return the list of entities
     */
    public Page<BikeDTO> findAllWithEagerRelationships(Pageable pageable) {
        return bikeRepository.findAllWithEagerRelationships(pageable).map(bikeMapper::toDto);
    }
    

    /**
     * Get one bike by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BikeDTO> findOne(Long id) {
        log.debug("Request to get Bike : {}", id);
        return bikeRepository.findOneWithEagerRelationships(id)
            .map(bikeMapper::toDto);
    }

    /**
     * Delete the bike by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Bike : {}", id);
        bikeRepository.deleteById(id);
    }
}
