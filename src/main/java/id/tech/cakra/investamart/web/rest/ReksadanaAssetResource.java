package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.ReksadanaAssetService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link id.tech.cakra.investamart.domain.ReksadanaAsset}.
 */
@RestController
@RequestMapping("/api")
public class ReksadanaAssetResource {

    private final Logger log = LoggerFactory.getLogger(ReksadanaAssetResource.class);

    private static final String ENTITY_NAME = "investacoresvcReksadanaAsset";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReksadanaAssetService reksadanaAssetService;

    public ReksadanaAssetResource(ReksadanaAssetService reksadanaAssetService) {
        this.reksadanaAssetService = reksadanaAssetService;
    }

    /**
     * {@code POST  /reksadana-assets} : Create a new reksadanaAsset.
     *
     * @param reksadanaAssetDTO the reksadanaAssetDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reksadanaAssetDTO, or with status {@code 400 (Bad Request)} if the reksadanaAsset has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reksadana-assets")
    public ResponseEntity<ReksadanaAssetDTO> createReksadanaAsset(@RequestBody ReksadanaAssetDTO reksadanaAssetDTO) throws URISyntaxException {
        log.debug("REST request to save ReksadanaAsset : {}", reksadanaAssetDTO);
        if (reksadanaAssetDTO.getId() != null) {
            throw new BadRequestAlertException("A new reksadanaAsset cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReksadanaAssetDTO result = reksadanaAssetService.save(reksadanaAssetDTO);
        return ResponseEntity.created(new URI("/api/reksadana-assets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reksadana-assets} : Updates an existing reksadanaAsset.
     *
     * @param reksadanaAssetDTO the reksadanaAssetDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reksadanaAssetDTO,
     * or with status {@code 400 (Bad Request)} if the reksadanaAssetDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reksadanaAssetDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reksadana-assets")
    public ResponseEntity<ReksadanaAssetDTO> updateReksadanaAsset(@RequestBody ReksadanaAssetDTO reksadanaAssetDTO) throws URISyntaxException {
        log.debug("REST request to update ReksadanaAsset : {}", reksadanaAssetDTO);
        if (reksadanaAssetDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReksadanaAssetDTO result = reksadanaAssetService.save(reksadanaAssetDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reksadanaAssetDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reksadana-assets} : get all the reksadanaAssets.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reksadanaAssets in body.
     */
    @GetMapping("/reksadana-assets")
    public List<ReksadanaAssetDTO> getAllReksadanaAssets() {
        log.debug("REST request to get all ReksadanaAssets");
        return reksadanaAssetService.findAll();
    }

    /**
     * {@code GET  /reksadana-assets/:id} : get the "id" reksadanaAsset.
     *
     * @param id the id of the reksadanaAssetDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reksadanaAssetDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reksadana-assets/{id}")
    public ResponseEntity<ReksadanaAssetDTO> getReksadanaAsset(@PathVariable Long id) {
        log.debug("REST request to get ReksadanaAsset : {}", id);
        Optional<ReksadanaAssetDTO> reksadanaAssetDTO = reksadanaAssetService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reksadanaAssetDTO);
    }

    /**
     * {@code DELETE  /reksadana-assets/:id} : delete the "id" reksadanaAsset.
     *
     * @param id the id of the reksadanaAssetDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reksadana-assets/{id}")
    public ResponseEntity<Void> deleteReksadanaAsset(@PathVariable Long id) {
        log.debug("REST request to delete ReksadanaAsset : {}", id);
        reksadanaAssetService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
