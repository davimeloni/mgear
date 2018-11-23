package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BikeBrakePadService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BikeBrakePadDTO;
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
 * REST controller for managing BikeBrakePad.
 */
@RestController
@RequestMapping("/api")
public class BikeBrakePadResource {

    private final Logger log = LoggerFactory.getLogger(BikeBrakePadResource.class);

    private static final String ENTITY_NAME = "bikeBrakePad";

    private final BikeBrakePadService bikeBrakePadService;

    public BikeBrakePadResource(BikeBrakePadService bikeBrakePadService) {
        this.bikeBrakePadService = bikeBrakePadService;
    }

    /**
     * POST  /bike-brake-pads : Create a new bikeBrakePad.
     *
     * @param bikeBrakePadDTO the bikeBrakePadDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bikeBrakePadDTO, or with status 400 (Bad Request) if the bikeBrakePad has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bike-brake-pads")
    @Timed
    public ResponseEntity<BikeBrakePadDTO> createBikeBrakePad(@RequestBody BikeBrakePadDTO bikeBrakePadDTO) throws URISyntaxException {
        log.debug("REST request to save BikeBrakePad : {}", bikeBrakePadDTO);
        if (bikeBrakePadDTO.getId() != null) {
            throw new BadRequestAlertException("A new bikeBrakePad cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BikeBrakePadDTO result = bikeBrakePadService.save(bikeBrakePadDTO);
        return ResponseEntity.created(new URI("/api/bike-brake-pads/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bike-brake-pads : Updates an existing bikeBrakePad.
     *
     * @param bikeBrakePadDTO the bikeBrakePadDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bikeBrakePadDTO,
     * or with status 400 (Bad Request) if the bikeBrakePadDTO is not valid,
     * or with status 500 (Internal Server Error) if the bikeBrakePadDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bike-brake-pads")
    @Timed
    public ResponseEntity<BikeBrakePadDTO> updateBikeBrakePad(@RequestBody BikeBrakePadDTO bikeBrakePadDTO) throws URISyntaxException {
        log.debug("REST request to update BikeBrakePad : {}", bikeBrakePadDTO);
        if (bikeBrakePadDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BikeBrakePadDTO result = bikeBrakePadService.save(bikeBrakePadDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bikeBrakePadDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bike-brake-pads : get all the bikeBrakePads.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of bikeBrakePads in body
     */
    @GetMapping("/bike-brake-pads")
    @Timed
    public List<BikeBrakePadDTO> getAllBikeBrakePads() {
        log.debug("REST request to get all BikeBrakePads");
        return bikeBrakePadService.findAll();
    }

    /**
     * GET  /bike-brake-pads/:id : get the "id" bikeBrakePad.
     *
     * @param id the id of the bikeBrakePadDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bikeBrakePadDTO, or with status 404 (Not Found)
     */
    @GetMapping("/bike-brake-pads/{id}")
    @Timed
    public ResponseEntity<BikeBrakePadDTO> getBikeBrakePad(@PathVariable Long id) {
        log.debug("REST request to get BikeBrakePad : {}", id);
        Optional<BikeBrakePadDTO> bikeBrakePadDTO = bikeBrakePadService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bikeBrakePadDTO);
    }

    /**
     * DELETE  /bike-brake-pads/:id : delete the "id" bikeBrakePad.
     *
     * @param id the id of the bikeBrakePadDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bike-brake-pads/{id}")
    @Timed
    public ResponseEntity<Void> deleteBikeBrakePad(@PathVariable Long id) {
        log.debug("REST request to delete BikeBrakePad : {}", id);
        bikeBrakePadService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
