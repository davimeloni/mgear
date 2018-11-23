package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.FrontSprocketConvService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.FrontSprocketConvDTO;
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
 * REST controller for managing FrontSprocketConv.
 */
@RestController
@RequestMapping("/api")
public class FrontSprocketConvResource {

    private final Logger log = LoggerFactory.getLogger(FrontSprocketConvResource.class);

    private static final String ENTITY_NAME = "frontSprocketConv";

    private final FrontSprocketConvService frontSprocketConvService;

    public FrontSprocketConvResource(FrontSprocketConvService frontSprocketConvService) {
        this.frontSprocketConvService = frontSprocketConvService;
    }

    /**
     * POST  /front-sprocket-convs : Create a new frontSprocketConv.
     *
     * @param frontSprocketConvDTO the frontSprocketConvDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new frontSprocketConvDTO, or with status 400 (Bad Request) if the frontSprocketConv has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/front-sprocket-convs")
    @Timed
    public ResponseEntity<FrontSprocketConvDTO> createFrontSprocketConv(@RequestBody FrontSprocketConvDTO frontSprocketConvDTO) throws URISyntaxException {
        log.debug("REST request to save FrontSprocketConv : {}", frontSprocketConvDTO);
        if (frontSprocketConvDTO.getId() != null) {
            throw new BadRequestAlertException("A new frontSprocketConv cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FrontSprocketConvDTO result = frontSprocketConvService.save(frontSprocketConvDTO);
        return ResponseEntity.created(new URI("/api/front-sprocket-convs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /front-sprocket-convs : Updates an existing frontSprocketConv.
     *
     * @param frontSprocketConvDTO the frontSprocketConvDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated frontSprocketConvDTO,
     * or with status 400 (Bad Request) if the frontSprocketConvDTO is not valid,
     * or with status 500 (Internal Server Error) if the frontSprocketConvDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/front-sprocket-convs")
    @Timed
    public ResponseEntity<FrontSprocketConvDTO> updateFrontSprocketConv(@RequestBody FrontSprocketConvDTO frontSprocketConvDTO) throws URISyntaxException {
        log.debug("REST request to update FrontSprocketConv : {}", frontSprocketConvDTO);
        if (frontSprocketConvDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        FrontSprocketConvDTO result = frontSprocketConvService.save(frontSprocketConvDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, frontSprocketConvDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /front-sprocket-convs : get all the frontSprocketConvs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of frontSprocketConvs in body
     */
    @GetMapping("/front-sprocket-convs")
    @Timed
    public List<FrontSprocketConvDTO> getAllFrontSprocketConvs() {
        log.debug("REST request to get all FrontSprocketConvs");
        return frontSprocketConvService.findAll();
    }

    /**
     * GET  /front-sprocket-convs/:id : get the "id" frontSprocketConv.
     *
     * @param id the id of the frontSprocketConvDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the frontSprocketConvDTO, or with status 404 (Not Found)
     */
    @GetMapping("/front-sprocket-convs/{id}")
    @Timed
    public ResponseEntity<FrontSprocketConvDTO> getFrontSprocketConv(@PathVariable Long id) {
        log.debug("REST request to get FrontSprocketConv : {}", id);
        Optional<FrontSprocketConvDTO> frontSprocketConvDTO = frontSprocketConvService.findOne(id);
        return ResponseUtil.wrapOrNotFound(frontSprocketConvDTO);
    }

    /**
     * DELETE  /front-sprocket-convs/:id : delete the "id" frontSprocketConv.
     *
     * @param id the id of the frontSprocketConvDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/front-sprocket-convs/{id}")
    @Timed
    public ResponseEntity<Void> deleteFrontSprocketConv(@PathVariable Long id) {
        log.debug("REST request to delete FrontSprocketConv : {}", id);
        frontSprocketConvService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
