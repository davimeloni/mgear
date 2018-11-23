package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BrakePadService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BrakePadDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing BrakePad.
 */
@RestController
@RequestMapping("/api")
public class BrakePadResource {

    private final Logger log = LoggerFactory.getLogger(BrakePadResource.class);

    private static final String ENTITY_NAME = "brakePad";

    private final BrakePadService brakePadService;

    public BrakePadResource(BrakePadService brakePadService) {
        this.brakePadService = brakePadService;
    }

    /**
     * POST  /brake-pads : Create a new brakePad.
     *
     * @param brakePadDTO the brakePadDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new brakePadDTO, or with status 400 (Bad Request) if the brakePad has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/brake-pads")
    @Timed
    public ResponseEntity<BrakePadDTO> createBrakePad(@Valid @RequestBody BrakePadDTO brakePadDTO) throws URISyntaxException {
        log.debug("REST request to save BrakePad : {}", brakePadDTO);
        if (brakePadDTO.getId() != null) {
            throw new BadRequestAlertException("A new brakePad cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BrakePadDTO result = brakePadService.save(brakePadDTO);
        return ResponseEntity.created(new URI("/api/brake-pads/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /brake-pads : Updates an existing brakePad.
     *
     * @param brakePadDTO the brakePadDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated brakePadDTO,
     * or with status 400 (Bad Request) if the brakePadDTO is not valid,
     * or with status 500 (Internal Server Error) if the brakePadDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/brake-pads")
    @Timed
    public ResponseEntity<BrakePadDTO> updateBrakePad(@Valid @RequestBody BrakePadDTO brakePadDTO) throws URISyntaxException {
        log.debug("REST request to update BrakePad : {}", brakePadDTO);
        if (brakePadDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BrakePadDTO result = brakePadService.save(brakePadDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, brakePadDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /brake-pads : get all the brakePads.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of brakePads in body
     */
    @GetMapping("/brake-pads")
    @Timed
    public List<BrakePadDTO> getAllBrakePads() {
        log.debug("REST request to get all BrakePads");
        return brakePadService.findAll();
    }

    /**
     * GET  /brake-pads/:id : get the "id" brakePad.
     *
     * @param id the id of the brakePadDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the brakePadDTO, or with status 404 (Not Found)
     */
    @GetMapping("/brake-pads/{id}")
    @Timed
    public ResponseEntity<BrakePadDTO> getBrakePad(@PathVariable Long id) {
        log.debug("REST request to get BrakePad : {}", id);
        Optional<BrakePadDTO> brakePadDTO = brakePadService.findOne(id);
        return ResponseUtil.wrapOrNotFound(brakePadDTO);
    }

    /**
     * DELETE  /brake-pads/:id : delete the "id" brakePad.
     *
     * @param id the id of the brakePadDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/brake-pads/{id}")
    @Timed
    public ResponseEntity<Void> deleteBrakePad(@PathVariable Long id) {
        log.debug("REST request to delete BrakePad : {}", id);
        brakePadService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
