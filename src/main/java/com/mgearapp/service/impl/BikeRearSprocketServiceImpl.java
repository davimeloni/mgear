package com.mgearapp.service.impl;

import com.mgearapp.service.BikeRearSprocketService;
import com.mgearapp.domain.BikeRearSprocket;
import com.mgearapp.repository.BikeRearSprocketRepository;
import com.mgearapp.service.dto.BikeRearSprocketDTO;
import com.mgearapp.service.mapper.BikeRearSprocketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BikeRearSprocket.
 */
@Service
@Transactional
public class BikeRearSprocketServiceImpl implements BikeRearSprocketService {

    private final Logger log = LoggerFactory.getLogger(BikeRearSprocketServiceImpl.class);

    private final BikeRearSprocketRepository bikeRearSprocketRepository;

    private final BikeRearSprocketMapper bikeRearSprocketMapper;

    public BikeRearSprocketServiceImpl(BikeRearSprocketRepository bikeRearSprocketRepository, BikeRearSprocketMapper bikeRearSprocketMapper) {
        this.bikeRearSprocketRepository = bikeRearSprocketRepository;
        this.bikeRearSprocketMapper = bikeRearSprocketMapper;
    }

    /**
     * Save a bikeRearSprocket.
     *
     * @param bikeRearSprocketDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BikeRearSprocketDTO save(BikeRearSprocketDTO bikeRearSprocketDTO) {
        log.debug("Request to save BikeRearSprocket : {}", bikeRearSprocketDTO);

        BikeRearSprocket bikeRearSprocket = bikeRearSprocketMapper.toEntity(bikeRearSprocketDTO);
        bikeRearSprocket = bikeRearSprocketRepository.save(bikeRearSprocket);
        return bikeRearSprocketMapper.toDto(bikeRearSprocket);
    }

    /**
     * Get all the bikeRearSprockets.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BikeRearSprocketDTO> findAll() {
        log.debug("Request to get all BikeRearSprockets");
        return bikeRearSprocketRepository.findAll().stream()
            .map(bikeRearSprocketMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one bikeRearSprocket by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BikeRearSprocketDTO> findOne(Long id) {
        log.debug("Request to get BikeRearSprocket : {}", id);
        return bikeRearSprocketRepository.findById(id)
            .map(bikeRearSprocketMapper::toDto);
    }

    /**
     * Delete the bikeRearSprocket by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BikeRearSprocket : {}", id);
        bikeRearSprocketRepository.deleteById(id);
    }
}
