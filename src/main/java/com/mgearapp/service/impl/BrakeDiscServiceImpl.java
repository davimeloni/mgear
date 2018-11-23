package com.mgearapp.service.impl;

import com.mgearapp.service.BrakeDiscService;
import com.mgearapp.domain.BrakeDisc;
import com.mgearapp.repository.BrakeDiscRepository;
import com.mgearapp.service.dto.BrakeDiscDTO;
import com.mgearapp.service.mapper.BrakeDiscMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BrakeDisc.
 */
@Service
@Transactional
public class BrakeDiscServiceImpl implements BrakeDiscService {

    private final Logger log = LoggerFactory.getLogger(BrakeDiscServiceImpl.class);

    private final BrakeDiscRepository brakeDiscRepository;

    private final BrakeDiscMapper brakeDiscMapper;

    public BrakeDiscServiceImpl(BrakeDiscRepository brakeDiscRepository, BrakeDiscMapper brakeDiscMapper) {
        this.brakeDiscRepository = brakeDiscRepository;
        this.brakeDiscMapper = brakeDiscMapper;
    }

    /**
     * Save a brakeDisc.
     *
     * @param brakeDiscDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BrakeDiscDTO save(BrakeDiscDTO brakeDiscDTO) {
        log.debug("Request to save BrakeDisc : {}", brakeDiscDTO);

        BrakeDisc brakeDisc = brakeDiscMapper.toEntity(brakeDiscDTO);
        brakeDisc = brakeDiscRepository.save(brakeDisc);
        return brakeDiscMapper.toDto(brakeDisc);
    }

    /**
     * Get all the brakeDiscs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BrakeDiscDTO> findAll() {
        log.debug("Request to get all BrakeDiscs");
        return brakeDiscRepository.findAll().stream()
            .map(brakeDiscMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one brakeDisc by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BrakeDiscDTO> findOne(Long id) {
        log.debug("Request to get BrakeDisc : {}", id);
        return brakeDiscRepository.findById(id)
            .map(brakeDiscMapper::toDto);
    }

    /**
     * Delete the brakeDisc by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BrakeDisc : {}", id);
        brakeDiscRepository.deleteById(id);
    }
}
