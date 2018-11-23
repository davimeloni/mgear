package com.mgearapp.service.impl;

import com.mgearapp.service.BikeBrakeDiscService;
import com.mgearapp.domain.BikeBrakeDisc;
import com.mgearapp.repository.BikeBrakeDiscRepository;
import com.mgearapp.service.dto.BikeBrakeDiscDTO;
import com.mgearapp.service.mapper.BikeBrakeDiscMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing BikeBrakeDisc.
 */
@Service
@Transactional
public class BikeBrakeDiscServiceImpl implements BikeBrakeDiscService {

    private final Logger log = LoggerFactory.getLogger(BikeBrakeDiscServiceImpl.class);

    private final BikeBrakeDiscRepository bikeBrakeDiscRepository;

    private final BikeBrakeDiscMapper bikeBrakeDiscMapper;

    public BikeBrakeDiscServiceImpl(BikeBrakeDiscRepository bikeBrakeDiscRepository, BikeBrakeDiscMapper bikeBrakeDiscMapper) {
        this.bikeBrakeDiscRepository = bikeBrakeDiscRepository;
        this.bikeBrakeDiscMapper = bikeBrakeDiscMapper;
    }

    /**
     * Save a bikeBrakeDisc.
     *
     * @param bikeBrakeDiscDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BikeBrakeDiscDTO save(BikeBrakeDiscDTO bikeBrakeDiscDTO) {
        log.debug("Request to save BikeBrakeDisc : {}", bikeBrakeDiscDTO);

        BikeBrakeDisc bikeBrakeDisc = bikeBrakeDiscMapper.toEntity(bikeBrakeDiscDTO);
        bikeBrakeDisc = bikeBrakeDiscRepository.save(bikeBrakeDisc);
        return bikeBrakeDiscMapper.toDto(bikeBrakeDisc);
    }

    /**
     * Get all the bikeBrakeDiscs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<BikeBrakeDiscDTO> findAll() {
        log.debug("Request to get all BikeBrakeDiscs");
        return bikeBrakeDiscRepository.findAll().stream()
            .map(bikeBrakeDiscMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one bikeBrakeDisc by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BikeBrakeDiscDTO> findOne(Long id) {
        log.debug("Request to get BikeBrakeDisc : {}", id);
        return bikeBrakeDiscRepository.findById(id)
            .map(bikeBrakeDiscMapper::toDto);
    }

    /**
     * Delete the bikeBrakeDisc by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BikeBrakeDisc : {}", id);
        bikeBrakeDiscRepository.deleteById(id);
    }
}
