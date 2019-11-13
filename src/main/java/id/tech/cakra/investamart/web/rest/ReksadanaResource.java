package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.ReksadanaService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.ReksadanaDTO;

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
 * REST controller for managing {@link id.tech.cakra.investamart.domain.Reksadana}.
 */
@RestController
@RequestMapping("/api")
public class ReksadanaResource {

    private final Logger log = LoggerFactory.getLogger(ReksadanaResource.class);

    private static final String ENTITY_NAME = "investacoresvcReksadana";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReksadanaService reksadanaService;

    public ReksadanaResource(ReksadanaService reksadanaService) {
        this.reksadanaService = reksadanaService;
    }

    /**
     * {@code POST  /reksadanas} : Create a new reksadana.
     *
     * @param reksadanaDTO the reksadanaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reksadanaDTO, or with status {@code 400 (Bad Request)} if the reksadana has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reksadanas")
    public ResponseEntity<ReksadanaDTO> createReksadana(@Valid @RequestBody ReksadanaDTO reksadanaDTO) throws URISyntaxException {
        log.debug("REST request to save Reksadana : {}", reksadanaDTO);
        if (reksadanaDTO.getId() != null) {
            throw new BadRequestAlertException("A new reksadana cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReksadanaDTO result = reksadanaService.save(reksadanaDTO);
        return ResponseEntity.created(new URI("/api/reksadanas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reksadanas} : Updates an existing reksadana.
     *
     * @param reksadanaDTO the reksadanaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reksadanaDTO,
     * or with status {@code 400 (Bad Request)} if the reksadanaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reksadanaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reksadanas")
    public ResponseEntity<ReksadanaDTO> updateReksadana(@Valid @RequestBody ReksadanaDTO reksadanaDTO) throws URISyntaxException {
        log.debug("REST request to update Reksadana : {}", reksadanaDTO);
        if (reksadanaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReksadanaDTO result = reksadanaService.save(reksadanaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reksadanaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reksadanas} : get all the reksadanas.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reksadanas in body.
     */
    @GetMapping("/reksadanas")
    public List<ReksadanaDTO> getAllReksadanas() {
        log.debug("REST request to get all Reksadanas");
        return reksadanaService.findAll();
    }

    /**
     * {@code GET  /reksadanas/:id} : get the "id" reksadana.
     *
     * @param id the id of the reksadanaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reksadanaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reksadanas/{id}")
    public ResponseEntity<ReksadanaDTO> getReksadana(@PathVariable Long id) {
        log.debug("REST request to get Reksadana : {}", id);
        Optional<ReksadanaDTO> reksadanaDTO = reksadanaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reksadanaDTO);
    }

    /**
     * {@code DELETE  /reksadanas/:id} : delete the "id" reksadana.
     *
     * @param id the id of the reksadanaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reksadanas/{id}")
    public ResponseEntity<Void> deleteReksadana(@PathVariable Long id) {
        log.debug("REST request to delete Reksadana : {}", id);
        reksadanaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
