package com.mgearapp.service.impl;

import com.mgearapp.service.BrakePadService;
import com.mgearapp.domain.BrakePad;
import com.mgearapp.repository.BrakePadRepository;
import com.mgearapp.service.dto.BrakePadDTO;
import com.mgearapp.service.mapper.BrakePadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BrakePad.
 */
@Service
@Transactional
public class BrakePadServiceImpl implements BrakePadService {

    private final Logger log = LoggerFactory.getLogger(BrakePadServiceImpl.class);

    private final BrakePadRepository brakePadRepository;

    private final BrakePadMapper brakePadMapper;

    public BrakePadServiceImpl(BrakePadRepository brakePadRepository, BrakePadMapper brakePadMapper) {
        this.brakePadRepository = brakePadRepository;
        this.brakePadMapper = brakePadMapper;
    }

    /**
     * Save a brakePad.
     *
     * @param brakePadDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BrakePadDTO save(BrakePadDTO brakePadDTO) {
        log.debug("Request to save BrakePad : {}", brakePadDTO);

        BrakePad brakePad = brakePadMapper.toEntity(brakePadDTO);
        brakePad = brakePadRepository.save(brakePad);
        return brakePadMapper.toDto(brakePad);
    }

    /**
     * Get all the brakePads.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BrakePadDTO> findAll() {
        log.debug("Request to get all BrakePads");
        return brakePadRepository.findAll().stream()
            .map(brakePadMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one brakePad by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BrakePadDTO> findOne(Long id) {
        log.debug("Request to get BrakePad : {}", id);
        return brakePadRepository.findById(id)
            .map(brakePadMapper::toDto);
    }

    /**
     * Delete the brakePad by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BrakePad : {}", id);
        brakePadRepository.deleteById(id);
    }
}
