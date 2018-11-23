package com.mgearapp.service.impl;

import com.mgearapp.service.RearSprocketConvService;
import com.mgearapp.domain.RearSprocketConv;
import com.mgearapp.repository.RearSprocketConvRepository;
import com.mgearapp.service.dto.RearSprocketConvDTO;
import com.mgearapp.service.mapper.RearSprocketConvMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing RearSprocketConv.
 */
@Service
@Transactional
public class RearSprocketConvServiceImpl implements RearSprocketConvService {

    private final Logger log = LoggerFactory.getLogger(RearSprocketConvServiceImpl.class);

    private final RearSprocketConvRepository rearSprocketConvRepository;

    private final RearSprocketConvMapper rearSprocketConvMapper;

    public RearSprocketConvServiceImpl(RearSprocketConvRepository rearSprocketConvRepository, RearSprocketConvMapper rearSprocketConvMapper) {
        this.rearSprocketConvRepository = rearSprocketConvRepository;
        this.rearSprocketConvMapper = rearSprocketConvMapper;
    }

    /**
     * Save a rearSprocketConv.
     *
     * @param rearSprocketConvDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RearSprocketConvDTO save(RearSprocketConvDTO rearSprocketConvDTO) {
        log.debug("Request to save RearSprocketConv : {}", rearSprocketConvDTO);

        RearSprocketConv rearSprocketConv = rearSprocketConvMapper.toEntity(rearSprocketConvDTO);
        rearSprocketConv = rearSprocketConvRepository.save(rearSprocketConv);
        return rearSprocketConvMapper.toDto(rearSprocketConv);
    }

    /**
     * Get all the rearSprocketConvs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RearSprocketConvDTO> findAll() {
        log.debug("Request to get all RearSprocketConvs");
        return rearSprocketConvRepository.findAll().stream()
            .map(rearSprocketConvMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one rearSprocketConv by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<RearSprocketConvDTO> findOne(Long id) {
        log.debug("Request to get RearSprocketConv : {}", id);
        return rearSprocketConvRepository.findById(id)
            .map(rearSprocketConvMapper::toDto);
    }

    /**
     * Delete the rearSprocketConv by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete RearSprocketConv : {}", id);
        rearSprocketConvRepository.deleteById(id);
    }
}
