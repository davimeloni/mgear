package com.mgearapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mgearapp.service.BikeService;
import com.mgearapp.web.rest.errors.BadRequestAlertException;
import com.mgearapp.web.rest.util.HeaderUtil;
import com.mgearapp.service.dto.BikeDTO;
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
 * REST controller for managing Bike.
 */
@RestController
@RequestMapping("/api")
public class BikeResource {

    private final Logger log = LoggerFactory.getLogger(BikeResource.class);

    private static final String ENTITY_NAME = "bike";

    private final BikeService bikeService;

    public BikeResource(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    /**
     * POST /bikes : Create a new bike.
     *
     * @param bikeDTO the bikeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         bikeDTO, or with status 400 (Bad Request) if the bike has already an
     *         ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bikes")
    @Timed
    public ResponseEntity<BikeDTO> createBike(@RequestBody BikeDTO bikeDTO) throws URISyntaxException {
        log.debug("REST request to save Bike : {}", bikeDTO);
        if (bikeDTO.getId() != null) {
            throw new BadRequestAlertException("A new bike cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BikeDTO result = bikeService.save(bikeDTO);
        return ResponseEntity.created(new URI("/api/bikes/" + result.getId()))
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString())).body(result);
    }

    /**
     * PUT /bikes : Updates an existing bike.
     *
     * @param bikeDTO the bikeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated
     *         bikeDTO, or with status 400 (Bad Request) if the bikeDTO is not
     *         valid, or with status 500 (Internal Server Error) if the bikeDTO
     *         couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bikes")
    @Timed
    public ResponseEntity<BikeDTO> updateBike(@RequestBody BikeDTO bikeDTO) throws URISyntaxException {
        log.debug("REST request to update Bike : {}", bikeDTO);
        if (bikeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BikeDTO result = bikeService.save(bikeDTO);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bikeDTO.getId().toString()))
                .body(result);
    }

    /**
     * GET /bikes : get all the bikes.
     *
     * @param eagerload flag to eager load entities from relationships (This is
     *                  applicable for many-to-many)
     * @return the ResponseEntity with status 200 (OK) and the list of bikes in body
     */
    @GetMapping("/bikes")
    @Timed
    public List<BikeDTO> getAllBikes(@RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get all Bikes");
        return bikeService.findAll();
    }

    /**
     * GET /bikes/:id : get the "id" bike.
     *
     * @param id the id of the bikeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bikeDTO, or
     *         with status 404 (Not Found)
     */
    @GetMapping("/bikes/{id}")
    @Timed
    public ResponseEntity<BikeDTO> getBike(@PathVariable Long id) {
        log.debug("REST request to get Bike : {}", id);
        Optional<BikeDTO> bikeDTO = bikeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bikeDTO);
    }

    /**
     * DELETE /bikes/:id : delete the "id" bike.
     *
     * @param id the id of the bikeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bikes/{id}")
    @Timed
    public ResponseEntity<Void> deleteBike(@PathVariable Long id) {
        log.debug("REST request to delete Bike : {}", id);
        bikeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

    /**
     * POST /bikes : Create a new bike.
     *
     * @param bikes the bikeDTO to create 
     * @return the ResponseEntity with status 201 (Created) and with body the new
     *         bikeDTO, or with status 400 (Bad Request) if the bike has already an
     *         ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bikescsv")
    @Timed
    public List<BikeDTO> importBikeCSV(@RequestBody List<BikeDTO> bikesDTO) throws URISyntaxException {
        log.debug("REST request to save Bikes via csv : {}", bikesDTO);
        List<BikeDTO> resultBikes = new ArrayList<BikeDTO>();
        List<Exception> errorList = new ArrayList<Exception>();
        for (BikeDTO bikeDTO : bikesDTO) {
            resultBikes.add(bikeService.save(bikeDTO));
        }
        return resultBikes;
    }
}
