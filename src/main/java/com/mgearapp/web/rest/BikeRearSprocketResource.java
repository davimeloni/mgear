package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BikeRearSprocketService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BikeRearSprocketDTO;
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
 * REST controller for managing BikeRearSprocket.
 */
@RestController
@RequestMapping("/api")
public class BikeRearSprocketResource {

    private final Logger log = LoggerFactory.getLogger(BikeRearSprocketResource.class);

    private static final String ENTITY_NAME = "bikeRearSprocket";

    private final BikeRearSprocketService bikeRearSprocketService;

    public BikeRearSprocketResource(BikeRearSprocketService bikeRearSprocketService) {
        this.bikeRearSprocketService = bikeRearSprocketService;
    }

    /**
     * POST  /bike-rear-sprockets : Create a new bikeRearSprocket.
     *
     * @param bikeRearSprocketDTO the bikeRearSprocketDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bikeRearSprocketDTO, or with status 400 (Bad Request) if the bikeRearSprocket has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bike-rear-sprockets")
    @Timed
    public ResponseEntity<BikeRearSprocketDTO> createBikeRearSprocket(@RequestBody BikeRearSprocketDTO bikeRearSprocketDTO) throws URISyntaxException {
        log.debug("REST request to save BikeRearSprocket : {}", bikeRearSprocketDTO);
        if (bikeRearSprocketDTO.getId() != null) {
            throw new BadRequestAlertException("A new bikeRearSprocket cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BikeRearSprocketDTO result = bikeRearSprocketService.save(bikeRearSprocketDTO);
        return ResponseEntity.created(new URI("/api/bike-rear-sprockets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bike-rear-sprockets : Updates an existing bikeRearSprocket.
     *
     * @param bikeRearSprocketDTO the bikeRearSprocketDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bikeRearSprocketDTO,
     * or with status 400 (Bad Request) if the bikeRearSprocketDTO is not valid,
     * or with status 500 (Internal Server Error) if the bikeRearSprocketDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bike-rear-sprockets")
    @Timed
    public ResponseEntity<BikeRearSprocketDTO> updateBikeRearSprocket(@RequestBody BikeRearSprocketDTO bikeRearSprocketDTO) throws URISyntaxException {
        log.debug("REST request to update BikeRearSprocket : {}", bikeRearSprocketDTO);
        if (bikeRearSprocketDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BikeRearSprocketDTO result = bikeRearSprocketService.save(bikeRearSprocketDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bikeRearSprocketDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bike-rear-sprockets : get all the bikeRearSprockets.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bikeRearSprockets in body
     */
    @GetMapping("/bike-rear-sprockets")
    @Timed
    public List<BikeRearSprocketDTO> getAllBikeRearSprockets() {
        log.debug("REST request to get all BikeRearSprockets");
        return bikeRearSprocketService.findAll();
    }

    /**
     * GET  /bike-rear-sprockets/:id : get the "id" bikeRearSprocket.
     *
     * @param id the id of the bikeRearSprocketDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bikeRearSprocketDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bike-rear-sprockets/{id}")
    @Timed
    public ResponseEntity<BikeRearSprocketDTO> getBikeRearSprocket(@PathVariable Long id) {
        log.debug("REST request to get BikeRearSprocket : {}", id);
        Optional<BikeRearSprocketDTO> bikeRearSprocketDTO = bikeRearSprocketService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bikeRearSprocketDTO);
    }

    /**
     * DELETE  /bike-rear-sprockets/:id : delete the "id" bikeRearSprocket.
     *
     * @param id the id of the bikeRearSprocketDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bike-rear-sprockets/{id}")
    @Timed
    public ResponseEntity<Void> deleteBikeRearSprocket(@PathVariable Long id) {
        log.debug("REST request to delete BikeRearSprocket : {}", id);
        bikeRearSprocketService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
