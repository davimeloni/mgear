package com.mgearapp.service.impl;

import com.mgearapp.service.BikeFrontSprocketService;
import com.mgearapp.domain.BikeFrontSprocket;
import com.mgearapp.repository.BikeFrontSprocketRepository;
import com.mgearapp.service.dto.BikeFrontSprocketDTO;
import com.mgearapp.service.mapper.BikeFrontSprocketMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BikeFrontSprocket.
 */
@Service
@Transactional
public class BikeFrontSprocketServiceImpl implements BikeFrontSprocketService {

    private final Logger log = LoggerFactory.getLogger(BikeFrontSprocketServiceImpl.class);

    private final BikeFrontSprocketRepository bikeFrontSprocketRepository;

    private final BikeFrontSprocketMapper bikeFrontSprocketMapper;

    public BikeFrontSprocketServiceImpl(BikeFrontSprocketRepository bikeFrontSprocketRepository, BikeFrontSprocketMapper bikeFrontSprocketMapper) {
        this.bikeFrontSprocketRepository = bikeFrontSprocketRepository;
        this.bikeFrontSprocketMapper = bikeFrontSprocketMapper;
    }

    /**
     * Save a bikeFrontSprocket.
     *
     * @param bikeFrontSprocketDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BikeFrontSprocketDTO save(BikeFrontSprocketDTO bikeFrontSprocketDTO) {
        log.debug("Request to save BikeFrontSprocket : {}", bikeFrontSprocketDTO);

        BikeFrontSprocket bikeFrontSprocket = bikeFrontSprocketMapper.toEntity(bikeFrontSprocketDTO);
        bikeFrontSprocket = bikeFrontSprocketRepository.save(bikeFrontSprocket);
        return bikeFrontSprocketMapper.toDto(bikeFrontSprocket);
    }

    /**
     * Get all the bikeFrontSprockets.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BikeFrontSprocketDTO> findAll() {
        log.debug("Request to get all BikeFrontSprockets");
        return bikeFrontSprocketRepository.findAll().stream()
            .map(bikeFrontSprocketMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one bikeFrontSprocket by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BikeFrontSprocketDTO> findOne(Long id) {
        log.debug("Request to get BikeFrontSprocket : {}", id);
        return bikeFrontSprocketRepository.findById(id)
            .map(bikeFrontSprocketMapper::toDto);
    }

    /**
     * Delete the bikeFrontSprocket by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BikeFrontSprocket : {}", id);
        bikeFrontSprocketRepository.deleteById(id);
    }
}
