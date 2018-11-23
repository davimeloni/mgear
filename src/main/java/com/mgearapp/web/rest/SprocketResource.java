package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.SprocketService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.SprocketDTO;
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
 * REST controller for managing Sprocket.
 */
@RestController
@RequestMapping("/api")
public class SprocketResource {

    private final Logger log = LoggerFactory.getLogger(SprocketResource.class);

    private static final String ENTITY_NAME = "sprocket";

    private final SprocketService sprocketService;

    public SprocketResource(SprocketService sprocketService) {
        this.sprocketService = sprocketService;
    }

    /**
     * POST  /sprockets : Create a new sprocket.
     *
     * @param sprocketDTO the sprocketDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new sprocketDTO, or with status 400 (Bad Request) if the sprocket has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/sprockets")
    @Timed
    public ResponseEntity<SprocketDTO> createSprocket(@RequestBody SprocketDTO sprocketDTO) throws URISyntaxException {
        log.debug("REST request to save Sprocket : {}", sprocketDTO);
        if (sprocketDTO.getId() != null) {
            throw new BadRequestAlertException("A new sprocket cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SprocketDTO result = sprocketService.save(sprocketDTO);
        return ResponseEntity.created(new URI("/api/sprockets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /sprockets : Updates an existing sprocket.
     *
     * @param sprocketDTO the sprocketDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated sprocketDTO,
     * or with status 400 (Bad Request) if the sprocketDTO is not valid,
     * or with status 500 (Internal Server Error) if the sprocketDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/sprockets")
    @Timed
    public ResponseEntity<SprocketDTO> updateSprocket(@RequestBody SprocketDTO sprocketDTO) throws URISyntaxException {
        log.debug("REST request to update Sprocket : {}", sprocketDTO);
        if (sprocketDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SprocketDTO result = sprocketService.save(sprocketDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, sprocketDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /sprockets : get all the sprockets.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of sprockets in body
     */
    @GetMapping("/sprockets")
    @Timed
    public List<SprocketDTO> getAllSprockets() {
        log.debug("REST request to get all Sprockets");
        return sprocketService.findAll();
    }

    /**
     * GET  /sprockets/:id : get the "id" sprocket.
     *
     * @param id the id of the sprocketDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the sprocketDTO, or with status 404 (Not Found)
     */
    @GetMapping("/sprockets/{id}")
    @Timed
    public ResponseEntity<SprocketDTO> getSprocket(@PathVariable Long id) {
        log.debug("REST request to get Sprocket : {}", id);
        Optional<SprocketDTO> sprocketDTO = sprocketService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sprocketDTO);
    }

    /**
     * DELETE  /sprockets/:id : delete the "id" sprocket.
     *
     * @param id the id of the sprocketDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/sprockets/{id}")
    @Timed
    public ResponseEntity<Void> deleteSprocket(@PathVariable Long id) {
        log.debug("REST request to delete Sprocket : {}", id);
        sprocketService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
