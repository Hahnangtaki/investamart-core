package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.ReksadanaAssetAllocationService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetAllocationDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link id.tech.cakra.investamart.domain.ReksadanaAssetAllocation}.
 */
@RestController
@RequestMapping("/api")
public class ReksadanaAssetAllocationResource {

    private final Logger log = LoggerFactory.getLogger(ReksadanaAssetAllocationResource.class);

    private static final String ENTITY_NAME = "investacoresvcReksadanaAssetAllocation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReksadanaAssetAllocationService reksadanaAssetAllocationService;

    public ReksadanaAssetAllocationResource(ReksadanaAssetAllocationService reksadanaAssetAllocationService) {
        this.reksadanaAssetAllocationService = reksadanaAssetAllocationService;
    }

    /**
     * {@code POST  /reksadana-asset-allocations} : Create a new reksadanaAssetAllocation.
     *
     * @param reksadanaAssetAllocationDTO the reksadanaAssetAllocationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reksadanaAssetAllocationDTO, or with status {@code 400 (Bad Request)} if the reksadanaAssetAllocation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reksadana-asset-allocations")
    public ResponseEntity<ReksadanaAssetAllocationDTO> createReksadanaAssetAllocation(@Valid @RequestBody ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO) throws URISyntaxException {
        log.debug("REST request to save ReksadanaAssetAllocation : {}", reksadanaAssetAllocationDTO);
        if (reksadanaAssetAllocationDTO.getId() != null) {
            throw new BadRequestAlertException("A new reksadanaAssetAllocation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReksadanaAssetAllocationDTO result = reksadanaAssetAllocationService.save(reksadanaAssetAllocationDTO);
        return ResponseEntity.created(new URI("/api/reksadana-asset-allocations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reksadana-asset-allocations} : Updates an existing reksadanaAssetAllocation.
     *
     * @param reksadanaAssetAllocationDTO the reksadanaAssetAllocationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reksadanaAssetAllocationDTO,
     * or with status {@code 400 (Bad Request)} if the reksadanaAssetAllocationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reksadanaAssetAllocationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reksadana-asset-allocations")
    public ResponseEntity<ReksadanaAssetAllocationDTO> updateReksadanaAssetAllocation(@Valid @RequestBody ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO) throws URISyntaxException {
        log.debug("REST request to update ReksadanaAssetAllocation : {}", reksadanaAssetAllocationDTO);
        if (reksadanaAssetAllocationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReksadanaAssetAllocationDTO result = reksadanaAssetAllocationService.save(reksadanaAssetAllocationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reksadanaAssetAllocationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reksadana-asset-allocations} : get all the reksadanaAssetAllocations.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reksadanaAssetAllocations in body.
     */
    @GetMapping("/reksadana-asset-allocations")
    public List<ReksadanaAssetAllocationDTO> getAllReksadanaAssetAllocations() {
        log.debug("REST request to get all ReksadanaAssetAllocations");
        return reksadanaAssetAllocationService.findAll();
    }

    /**
     * {@code GET  /reksadana-asset-allocations/:id} : get the "id" reksadanaAssetAllocation.
     *
     * @param id the id of the reksadanaAssetAllocationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reksadanaAssetAllocationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reksadana-asset-allocations/{id}")
    public ResponseEntity<ReksadanaAssetAllocationDTO> getReksadanaAssetAllocation(@PathVariable Long id) {
        log.debug("REST request to get ReksadanaAssetAllocation : {}", id);
        Optional<ReksadanaAssetAllocationDTO> reksadanaAssetAllocationDTO = reksadanaAssetAllocationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reksadanaAssetAllocationDTO);
    }

    /**
     * {@code DELETE  /reksadana-asset-allocations/:id} : delete the "id" reksadanaAssetAllocation.
     *
     * @param id the id of the reksadanaAssetAllocationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reksadana-asset-allocations/{id}")
    public ResponseEntity<Void> deleteReksadanaAssetAllocation(@PathVariable Long id) {
        log.debug("REST request to delete ReksadanaAssetAllocation : {}", id);
        reksadanaAssetAllocationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
