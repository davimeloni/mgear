package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BrakeDiscService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BrakeDiscDTO;
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
 * REST controller for managing BrakeDisc.
 */
@RestController
@RequestMapping("/api")
public class BrakeDiscResource {

    private final Logger log = LoggerFactory.getLogger(BrakeDiscResource.class);

    private static final String ENTITY_NAME = "brakeDisc";

    private final BrakeDiscService brakeDiscService;

    public BrakeDiscResource(BrakeDiscService brakeDiscService) {
        this.brakeDiscService = brakeDiscService;
    }

    /**
     * POST  /brake-discs : Create a new brakeDisc.
     *
     * @param brakeDiscDTO the brakeDiscDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new brakeDiscDTO, or with status 400 (Bad Request) if the brakeDisc has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/brake-discs")
    @Timed
    public ResponseEntity<BrakeDiscDTO> createBrakeDisc(@Valid @RequestBody BrakeDiscDTO brakeDiscDTO) throws URISyntaxException {
        log.debug("REST request to save BrakeDisc : {}", brakeDiscDTO);
        if (brakeDiscDTO.getId() != null) {
            throw new BadRequestAlertException("A new brakeDisc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BrakeDiscDTO result = brakeDiscService.save(brakeDiscDTO);
        return ResponseEntity.created(new URI("/api/brake-discs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /brake-discs : Updates an existing brakeDisc.
     *
     * @param brakeDiscDTO the brakeDiscDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated brakeDiscDTO,
     * or with status 400 (Bad Request) if the brakeDiscDTO is not valid,
     * or with status 500 (Internal Server Error) if the brakeDiscDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/brake-discs")
    @Timed
    public ResponseEntity<BrakeDiscDTO> updateBrakeDisc(@Valid @RequestBody BrakeDiscDTO brakeDiscDTO) throws URISyntaxException {
        log.debug("REST request to update BrakeDisc : {}", brakeDiscDTO);
        if (brakeDiscDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BrakeDiscDTO result = brakeDiscService.save(brakeDiscDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, brakeDiscDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /brake-discs : get all the brakeDiscs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of brakeDiscs in body
     */
    @GetMapping("/brake-discs")
    @Timed
    public List<BrakeDiscDTO> getAllBrakeDiscs() {
        log.debug("REST request to get all BrakeDiscs");
        return brakeDiscService.findAll();
    }

    /**
     * GET  /brake-discs/:id : get the "id" brakeDisc.
     *
     * @param id the id of the brakeDiscDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the brakeDiscDTO, or with status 404 (Not Found)
     */
    @GetMapping("/brake-discs/{id}")
    @Timed
    public ResponseEntity<BrakeDiscDTO> getBrakeDisc(@PathVariable Long id) {
        log.debug("REST request to get BrakeDisc : {}", id);
        Optional<BrakeDiscDTO> brakeDiscDTO = brakeDiscService.findOne(id);
        return ResponseUtil.wrapOrNotFound(brakeDiscDTO);
    }

    /**
     * DELETE  /brake-discs/:id : delete the "id" brakeDisc.
     *
     * @param id the id of the brakeDiscDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/brake-discs/{id}")
    @Timed
    public ResponseEntity<Void> deleteBrakeDisc(@PathVariable Long id) {
        log.debug("REST request to delete BrakeDisc : {}", id);
        brakeDiscService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
