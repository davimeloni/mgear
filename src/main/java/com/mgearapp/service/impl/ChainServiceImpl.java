package com.mgearapp.service.impl;

import com.mgearapp.service.ChainService;
import com.mgearapp.domain.Chain;
import com.mgearapp.repository.ChainRepository;
import com.mgearapp.service.dto.ChainDTO;
import com.mgearapp.service.mapper.ChainMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Chain.
 */
@Service
@Transactional
public class ChainServiceImpl implements ChainService {

    private final Logger log = LoggerFactory.getLogger(ChainServiceImpl.class);

    private final ChainRepository chainRepository;

    private final ChainMapper chainMapper;

    public ChainServiceImpl(ChainRepository chainRepository, ChainMapper chainMapper) {
        this.chainRepository = chainRepository;
        this.chainMapper = chainMapper;
    }

    /**
     * Save a chain.
     *
     * @param chainDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ChainDTO save(ChainDTO chainDTO) {
        log.debug("Request to save Chain : {}", chainDTO);

        Chain chain = chainMapper.toEntity(chainDTO);
        chain = chainRepository.save(chain);
        return chainMapper.toDto(chain);
    }

    /**
     * Get all the chains.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ChainDTO> findAll() {
        log.debug("Request to get all Chains");
        return chainRepository.findAll().stream()
            .map(chainMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one chain by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ChainDTO> findOne(Long id) {
        log.debug("Request to get Chain : {}", id);
        return chainRepository.findById(id)
            .map(chainMapper::toDto);
    }

    /**
     * Delete the chain by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Chain : {}", id);
        chainRepository.deleteById(id);
    }
}
