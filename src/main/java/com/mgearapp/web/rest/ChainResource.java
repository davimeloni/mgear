package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.ChainService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.ChainDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Chain.
 */
@RestController
@RequestMapping("/api")
public class ChainResource {

    private final Logger log = LoggerFactory.getLogger(ChainResource.class);

    private static final String ENTITY_NAME = "chain";

    private final ChainService chainService;

    public ChainResource(ChainService chainService) {
        this.chainService = chainService;
    }

    /**
     * POST  /chains : Create a new chain.
     *
     * @param chainDTO the chainDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new chainDTO, or with status 400 (Bad Request) if the chain has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/chains")
    @Timed
    public ResponseEntity<ChainDTO> createChain(@RequestBody ChainDTO chainDTO) throws URISyntaxException {
        log.debug("REST request to save Chain : {}", chainDTO);
        if (chainDTO.getId() != null) {
            throw new BadRequestAlertException("A new chain cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ChainDTO result = chainService.save(chainDTO);
        return ResponseEntity.created(new URI("/api/chains/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /chains : Updates an existing chain.
     *
     * @param chainDTO the chainDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated chainDTO,
     * or with status 400 (Bad Request) if the chainDTO is not valid,
     * or with status 500 (Internal Server Error) if the chainDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/chains")
    @Timed
    public ResponseEntity<ChainDTO> updateChain(@RequestBody ChainDTO chainDTO) throws URISyntaxException {
        log.debug("REST request to update Chain : {}", chainDTO);
        if (chainDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ChainDTO result = chainService.save(chainDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, chainDTO.getId().toString()))
            .body(result);
    }
    

    /**
     * GET  /chains : get all the chains.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of chains in body
     */
    @GetMapping("/chains")
    @Timed
    public List<ChainDTO> getAllChains() {
        log.debug("REST request to get all Chains");
        return chainService.findAll();
    }

    /**
     * GET  /chains/:id : get the "id" chain.
     *
     * @param id the id of the chainDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the chainDTO, or with status 404 (Not Found)
     */
    @GetMapping("/chains/{id}")
    @Timed
    public ResponseEntity<ChainDTO> getChain(@PathVariable Long id) {
        log.debug("REST request to get Chain : {}", id);
        Optional<ChainDTO> chainDTO = chainService.findOne(id);
        return ResponseUtil.wrapOrNotFound(chainDTO);
    }

    /**
     * DELETE  /chains/:id : delete the "id" chain.
     *
     * @param id the id of the chainDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/chains/{id}")
    @Timed
    public ResponseEntity<Void> deleteChain(@PathVariable Long id) {
        log.debug("REST request to delete Chain : {}", id);
        chainService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * PUT  /chains : Updates an existing chain.
     *
     * @param chains the chainDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated chainDTO,
     * or with status 400 (Bad Request) if the chainDTO is not valid,
     * or with status 500 (Internal Server Error) if the chainDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/chains2")
    @Timed
    public Object updateChain2(@RequestBody List<ChainDTO> chains) throws URISyntaxException {
        List<ChainDTO> resultChains = new ArrayList<ChainDTO>();
        List<Exception> errorList = new ArrayList<Exception>();
        log.debug("REST request to update Chain lots of chains: {}", chains);
        for (ChainDTO chain: chains) {
            try {
                resultChains.add(chainService.save(chain));          
            } catch (Exception e) {
                //TODO: handle exception
                errorList.add(e);
                continue;
            }
        }

        return new Object[]{resultChains, errorList};
    }
    
    
}
