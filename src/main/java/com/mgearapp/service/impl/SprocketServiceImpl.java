package com.mgearapp.service.impl;

import com.mgearapp.service.SprocketService;
import com.mgearapp.domain.Sprocket;
import com.mgearapp.repository.SprocketRepository;
import com.mgearapp.service.dto.SprocketDTO;
import com.mgearapp.service.mapper.SprocketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Sprocket.
 */
@Service
@Transactional
public class SprocketServiceImpl implements SprocketService {

    private final Logger log = LoggerFactory.getLogger(SprocketServiceImpl.class);

    private final SprocketRepository sprocketRepository;

    private final SprocketMapper sprocketMapper;

    public SprocketServiceImpl(SprocketRepository sprocketRepository, SprocketMapper sprocketMapper) {
        this.sprocketRepository = sprocketRepository;
        this.sprocketMapper = sprocketMapper;
    }

    /**
     * Save a sprocket.
     *
     * @param sprocketDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SprocketDTO save(SprocketDTO sprocketDTO) {
        log.debug("Request to save Sprocket : {}", sprocketDTO);

        Sprocket sprocket = sprocketMapper.toEntity(sprocketDTO);
        sprocket = sprocketRepository.save(sprocket);
        return sprocketMapper.toDto(sprocket);
    }

    /**
     * Get all the sprockets.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<SprocketDTO> findAll() {
        log.debug("Request to get all Sprockets");
        return sprocketRepository.findAll().stream()
            .map(sprocketMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one sprocket by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<SprocketDTO> findOne(Long id) {
        log.debug("Request to get Sprocket : {}", id);
        return sprocketRepository.findById(id)
            .map(sprocketMapper::toDto);
    }

    /**
     * Delete the sprocket by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sprocket : {}", id);
        sprocketRepository.deleteById(id);
    }
}
