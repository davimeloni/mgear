package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BikeBrakeDiscService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BikeBrakeDiscDTO;
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
 * REST controller for managing BikeBrakeDisc.
 */
@RestController
@RequestMapping("/api")
public class BikeBrakeDiscResource {

    private final Logger log = LoggerFactory.getLogger(BikeBrakeDiscResource.class);

    private static final String ENTITY_NAME = "bikeBrakeDisc";

    private final BikeBrakeDiscService bikeBrakeDiscService;

    public BikeBrakeDiscResource(BikeBrakeDiscService bikeBrakeDiscService) {
        this.bikeBrakeDiscService = bikeBrakeDiscService;
    }

    /**
     * POST  /bike-brake-discs : Create a new bikeBrakeDisc.
     *
     * @param bikeBrakeDiscDTO the bikeBrakeDiscDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bikeBrakeDiscDTO, or with status 400 (Bad Request) if the bikeBrakeDisc has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bike-brake-discs")
    @Timed
    public ResponseEntity<BikeBrakeDiscDTO> createBikeBrakeDisc(@RequestBody BikeBrakeDiscDTO bikeBrakeDiscDTO) throws URISyntaxException {
        log.debug("REST request to save BikeBrakeDisc : {}", bikeBrakeDiscDTO);
        if (bikeBrakeDiscDTO.getId() != null) {
            throw new BadRequestAlertException("A new bikeBrakeDisc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BikeBrakeDiscDTO result = bikeBrakeDiscService.save(bikeBrakeDiscDTO);
        return ResponseEntity.created(new URI("/api/bike-brake-discs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bike-brake-discs : Updates an existing bikeBrakeDisc.
     *
     * @param bikeBrakeDiscDTO the bikeBrakeDiscDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bikeBrakeDiscDTO,
     * or with status 400 (Bad Request) if the bikeBrakeDiscDTO is not valid,
     * or with status 500 (Internal Server Error) if the bikeBrakeDiscDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bike-brake-discs")
    @Timed
    public ResponseEntity<BikeBrakeDiscDTO> updateBikeBrakeDisc(@RequestBody BikeBrakeDiscDTO bikeBrakeDiscDTO) throws URISyntaxException {
        log.debug("REST request to update BikeBrakeDisc : {}", bikeBrakeDiscDTO);
        if (bikeBrakeDiscDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BikeBrakeDiscDTO result = bikeBrakeDiscService.save(bikeBrakeDiscDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bikeBrakeDiscDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bike-brake-discs : get all the bikeBrakeDiscs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bikeBrakeDiscs in body
     */
    @GetMapping("/bike-brake-discs")
    @Timed
    public List<BikeBrakeDiscDTO> getAllBikeBrakeDiscs() {
        log.debug("REST request to get all BikeBrakeDiscs");
        return bikeBrakeDiscService.findAll();
    }

    /**
     * GET  /bike-brake-discs/:id : get the "id" bikeBrakeDisc.
     *
     * @param id the id of the bikeBrakeDiscDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bikeBrakeDiscDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bike-brake-discs/{id}")
    @Timed
    public ResponseEntity<BikeBrakeDiscDTO> getBikeBrakeDisc(@PathVariable Long id) {
        log.debug("REST request to get BikeBrakeDisc : {}", id);
        Optional<BikeBrakeDiscDTO> bikeBrakeDiscDTO = bikeBrakeDiscService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bikeBrakeDiscDTO);
    }

    /**
     * DELETE  /bike-brake-discs/:id : delete the "id" bikeBrakeDisc.
     *
     * @param id the id of the bikeBrakeDiscDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bike-brake-discs/{id}")
    @Timed
    public ResponseEntity<Void> deleteBikeBrakeDisc(@PathVariable Long id) {
        log.debug("REST request to delete BikeBrakeDisc : {}", id);
        bikeBrakeDiscService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
