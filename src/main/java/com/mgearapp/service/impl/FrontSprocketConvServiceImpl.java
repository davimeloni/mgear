package com.mgearapp.service.impl;

import com.mgearapp.service.FrontSprocketConvService;
import com.mgearapp.domain.FrontSprocketConv;
import com.mgearapp.repository.FrontSprocketConvRepository;
import com.mgearapp.service.dto.FrontSprocketConvDTO;
import com.mgearapp.service.mapper.FrontSprocketConvMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing FrontSprocketConv.
 */
@Service
@Transactional
public class FrontSprocketConvServiceImpl implements FrontSprocketConvService {

    private final Logger log = LoggerFactory.getLogger(FrontSprocketConvServiceImpl.class);

    private final FrontSprocketConvRepository frontSprocketConvRepository;

    private final FrontSprocketConvMapper frontSprocketConvMapper;

    public FrontSprocketConvServiceImpl(FrontSprocketConvRepository frontSprocketConvRepository, FrontSprocketConvMapper frontSprocketConvMapper) {
        this.frontSprocketConvRepository = frontSprocketConvRepository;
        this.frontSprocketConvMapper = frontSprocketConvMapper;
    }

    /**
     * Save a frontSprocketConv.
     *
     * @param frontSprocketConvDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FrontSprocketConvDTO save(FrontSprocketConvDTO frontSprocketConvDTO) {
        log.debug("Request to save FrontSprocketConv : {}", frontSprocketConvDTO);

        FrontSprocketConv frontSprocketConv = frontSprocketConvMapper.toEntity(frontSprocketConvDTO);
        frontSprocketConv = frontSprocketConvRepository.save(frontSprocketConv);
        return frontSprocketConvMapper.toDto(frontSprocketConv);
    }

    /**
     * Get all the frontSprocketConvs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<FrontSprocketConvDTO> findAll() {
        log.debug("Request to get all FrontSprocketConvs");
        return frontSprocketConvRepository.findAll().stream()
            .map(frontSprocketConvMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one frontSprocketConv by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FrontSprocketConvDTO> findOne(Long id) {
        log.debug("Request to get FrontSprocketConv : {}", id);
        return frontSprocketConvRepository.findById(id)
            .map(frontSprocketConvMapper::toDto);
    }

    /**
     * Delete the frontSprocketConv by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete FrontSprocketConv : {}", id);
        frontSprocketConvRepository.deleteById(id);
    }
}
