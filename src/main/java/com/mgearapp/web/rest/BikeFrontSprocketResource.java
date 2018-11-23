package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BikeFrontSprocketService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BikeFrontSprocketDTO;
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
 * REST controller for managing BikeFrontSprocket.
 */
@RestController
@RequestMapping("/api")
public class BikeFrontSprocketResource {

    private final Logger log = LoggerFactory.getLogger(BikeFrontSprocketResource.class);

    private static final String ENTITY_NAME = "bikeFrontSprocket";

    private final BikeFrontSprocketService bikeFrontSprocketService;

    public BikeFrontSprocketResource(BikeFrontSprocketService bikeFrontSprocketService) {
        this.bikeFrontSprocketService = bikeFrontSprocketService;
    }

    /**
     * POST  /bike-front-sprockets : Create a new bikeFrontSprocket.
     *
     * @param bikeFrontSprocketDTO the bikeFrontSprocketDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bikeFrontSprocketDTO, or with status 400 (Bad Request) if the bikeFrontSprocket has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bike-front-sprockets")
    @Timed
    public ResponseEntity<BikeFrontSprocketDTO> createBikeFrontSprocket(@RequestBody BikeFrontSprocketDTO bikeFrontSprocketDTO) throws URISyntaxException {
        log.debug("REST request to save BikeFrontSprocket : {}", bikeFrontSprocketDTO);
        if (bikeFrontSprocketDTO.getId() != null) {
            throw new BadRequestAlertException("A new bikeFrontSprocket cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BikeFrontSprocketDTO result = bikeFrontSprocketService.save(bikeFrontSprocketDTO);
        return ResponseEntity.created(new URI("/api/bike-front-sprockets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bike-front-sprockets : Updates an existing bikeFrontSprocket.
     *
     * @param bikeFrontSprocketDTO the bikeFrontSprocketDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bikeFrontSprocketDTO,
     * or with status 400 (Bad Request) if the bikeFrontSprocketDTO is not valid,
     * or with status 500 (Internal Server Error) if the bikeFrontSprocketDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bike-front-sprockets")
    @Timed
    public ResponseEntity<BikeFrontSprocketDTO> updateBikeFrontSprocket(@RequestBody BikeFrontSprocketDTO bikeFrontSprocketDTO) throws URISyntaxException {
        log.debug("REST request to update BikeFrontSprocket : {}", bikeFrontSprocketDTO);
        if (bikeFrontSprocketDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BikeFrontSprocketDTO result = bikeFrontSprocketService.save(bikeFrontSprocketDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bikeFrontSprocketDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bike-front-sprockets : get all the bikeFrontSprockets.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bikeFrontSprockets in body
     */
    @GetMapping("/bike-front-sprockets")
    @Timed
    public List<BikeFrontSprocketDTO> getAllBikeFrontSprockets() {
        log.debug("REST request to get all BikeFrontSprockets");
        return bikeFrontSprocketService.findAll();
    }

    /**
     * GET  /bike-front-sprockets/:id : get the "id" bikeFrontSprocket.
     *
     * @param id the id of the bikeFrontSprocketDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bikeFrontSprocketDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bike-front-sprockets/{id}")
    @Timed
    public ResponseEntity<BikeFrontSprocketDTO> getBikeFrontSprocket(@PathVariable Long id) {
        log.debug("REST request to get BikeFrontSprocket : {}", id);
        Optional<BikeFrontSprocketDTO> bikeFrontSprocketDTO = bikeFrontSprocketService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bikeFrontSprocketDTO);
    }

    /**
     * DELETE  /bike-front-sprockets/:id : delete the "id" bikeFrontSprocket.
     *
     * @param id the id of the bikeFrontSprocketDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bike-front-sprockets/{id}")
    @Timed
    public ResponseEntity<Void> deleteBikeFrontSprocket(@PathVariable Long id) {
        log.debug("REST request to delete BikeFrontSprocket : {}", id);
        bikeFrontSprocketService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
