package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.RearSprocketConvService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.RearSprocketConvDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing RearSprocketConv.
 */
@RestController
@RequestMapping("/api")
public class RearSprocketConvResource {

    private final Logger log = LoggerFactory.getLogger(RearSprocketConvResource.class);

    private static final String ENTITY_NAME = "rearSprocketConv";

    private final RearSprocketConvService rearSprocketConvService;

    public RearSprocketConvResource(RearSprocketConvService rearSprocketConvService) {
        this.rearSprocketConvService = rearSprocketConvService;
    }

    /**
     * POST  /rear-sprocket-convs : Create a new rearSprocketConv.
     *
     * @param rearSprocketConvDTO the rearSprocketConvDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rearSprocketConvDTO, or with status 400 (Bad Request) if the rearSprocketConv has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/rear-sprocket-convs")
    @Timed
    public ResponseEntity<RearSprocketConvDTO> createRearSprocketConv(@RequestBody RearSprocketConvDTO rearSprocketConvDTO) throws URISyntaxException {
        log.debug("REST request to save RearSprocketConv : {}", rearSprocketConvDTO);
        if (rearSprocketConvDTO.getId() != null) {
            throw new BadRequestAlertException("A new rearSprocketConv cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RearSprocketConvDTO result = rearSprocketConvService.save(rearSprocketConvDTO);
        return ResponseEntity.created(new URI("/api/rear-sprocket-convs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /rear-sprocket-convs : Updates an existing rearSprocketConv.
     *
     * @param rearSprocketConvDTO the rearSprocketConvDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rearSprocketConvDTO,
     * or with status 400 (Bad Request) if the rearSprocketConvDTO is not valid,
     * or with status 500 (Internal Server Error) if the rearSprocketConvDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/rear-sprocket-convs")
    @Timed
    public ResponseEntity<RearSprocketConvDTO> updateRearSprocketConv(@RequestBody RearSprocketConvDTO rearSprocketConvDTO) throws URISyntaxException {
        log.debug("REST request to update RearSprocketConv : {}", rearSprocketConvDTO);
        if (rearSprocketConvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RearSprocketConvDTO result = rearSprocketConvService.save(rearSprocketConvDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rearSprocketConvDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /rear-sprocket-convs : get all the rearSprocketConvs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rearSprocketConvs in body
     */
    @GetMapping("/rear-sprocket-convs")
    @Timed
    public List<RearSprocketConvDTO> getAllRearSprocketConvs() {
        log.debug("REST request to get all RearSprocketConvs");
        return rearSprocketConvService.findAll();
    }

    /**
     * GET  /rear-sprocket-convs/:id : get the "id" rearSprocketConv.
     *
     * @param id the id of the rearSprocketConvDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rearSprocketConvDTO, or with status 404 (Not Found)
     */
    @GetMapping("/rear-sprocket-convs/{id}")
    @Timed
    public ResponseEntity<RearSprocketConvDTO> getRearSprocketConv(@PathVariable Long id) {
        log.debug("REST request to get RearSprocketConv : {}", id);
        Optional<RearSprocketConvDTO> rearSprocketConvDTO = rearSprocketConvService.findOne(id);
        return ResponseUtil.wrapOrNotFound(rearSprocketConvDTO);
    }

    /**
     * DELETE  /rear-sprocket-convs/:id : delete the "id" rearSprocketConv.
     *
     * @param id the id of the rearSprocketConvDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/rear-sprocket-convs/{id}")
    @Timed
    public ResponseEntity<Void> deleteRearSprocketConv(@PathVariable Long id) {
        log.debug("REST request to delete RearSprocketConv : {}", id);
        rearSprocketConvService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
