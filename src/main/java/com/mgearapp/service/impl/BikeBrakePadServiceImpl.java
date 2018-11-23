package com.mgearapp.service.impl;

import com.mgearapp.service.BikeBrakePadService;
import com.mgearapp.domain.BikeBrakePad;
import com.mgearapp.repository.BikeBrakePadRepository;
import com.mgearapp.service.dto.BikeBrakePadDTO;
import com.mgearapp.service.mapper.BikeBrakePadMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BikeBrakePad.
 */
@Service
@Transactional
public class BikeBrakePadServiceImpl implements BikeBrakePadService {

    private final Logger log = LoggerFactory.getLogger(BikeBrakePadServiceImpl.class);

    private final BikeBrakePadRepository bikeBrakePadRepository;

    private final BikeBrakePadMapper bikeBrakePadMapper;

    public BikeBrakePadServiceImpl(BikeBrakePadRepository bikeBrakePadRepository, BikeBrakePadMapper bikeBrakePadMapper) {
        this.bikeBrakePadRepository = bikeBrakePadRepository;
        this.bikeBrakePadMapper = bikeBrakePadMapper;
    }

    /**
     * Save a bikeBrakePad.
     *
     * @param bikeBrakePadDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BikeBrakePadDTO save(BikeBrakePadDTO bikeBrakePadDTO) {
        log.debug("Request to save BikeBrakePad : {}", bikeBrakePadDTO);

        BikeBrakePad bikeBrakePad = bikeBrakePadMapper.toEntity(bikeBrakePadDTO);
        bikeBrakePad = bikeBrakePadRepository.save(bikeBrakePad);
        return bikeBrakePadMapper.toDto(bikeBrakePad);
    }

    /**
     * Get all the bikeBrakePads.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BikeBrakePadDTO> findAll() {
        log.debug("Request to get all BikeBrakePads");
        return bikeBrakePadRepository.findAll().stream()
            .map(bikeBrakePadMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one bikeBrakePad by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BikeBrakePadDTO> findOne(Long id) {
        log.debug("Request to get BikeBrakePad : {}", id);
        return bikeBrakePadRepository.findById(id)
            .map(bikeBrakePadMapper::toDto);
    }

    /**
     * Delete the bikeBrakePad by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BikeBrakePad : {}", id);
        bikeBrakePadRepository.deleteById(id);
    }
}
