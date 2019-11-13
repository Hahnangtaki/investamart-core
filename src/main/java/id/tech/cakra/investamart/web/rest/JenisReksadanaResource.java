package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.JenisReksadanaService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.JenisReksadanaDTO;

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
 * REST controller for managing {@link id.tech.cakra.investamart.domain.JenisReksadana}.
 */
@RestController
@RequestMapping("/api")
public class JenisReksadanaResource {

    private final Logger log = LoggerFactory.getLogger(JenisReksadanaResource.class);

    private static final String ENTITY_NAME = "investacoresvcJenisReksadana";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JenisReksadanaService jenisReksadanaService;

    public JenisReksadanaResource(JenisReksadanaService jenisReksadanaService) {
        this.jenisReksadanaService = jenisReksadanaService;
    }

    /**
     * {@code POST  /jenis-reksadanas} : Create a new jenisReksadana.
     *
     * @param jenisReksadanaDTO the jenisReksadanaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jenisReksadanaDTO, or with status {@code 400 (Bad Request)} if the jenisReksadana has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jenis-reksadanas")
    public ResponseEntity<JenisReksadanaDTO> createJenisReksadana(@Valid @RequestBody JenisReksadanaDTO jenisReksadanaDTO) throws URISyntaxException {
        log.debug("REST request to save JenisReksadana : {}", jenisReksadanaDTO);
        if (jenisReksadanaDTO.getId() != null) {
            throw new BadRequestAlertException("A new jenisReksadana cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JenisReksadanaDTO result = jenisReksadanaService.save(jenisReksadanaDTO);
        return ResponseEntity.created(new URI("/api/jenis-reksadanas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jenis-reksadanas} : Updates an existing jenisReksadana.
     *
     * @param jenisReksadanaDTO the jenisReksadanaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jenisReksadanaDTO,
     * or with status {@code 400 (Bad Request)} if the jenisReksadanaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jenisReksadanaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jenis-reksadanas")
    public ResponseEntity<JenisReksadanaDTO> updateJenisReksadana(@Valid @RequestBody JenisReksadanaDTO jenisReksadanaDTO) throws URISyntaxException {
        log.debug("REST request to update JenisReksadana : {}", jenisReksadanaDTO);
        if (jenisReksadanaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JenisReksadanaDTO result = jenisReksadanaService.save(jenisReksadanaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, jenisReksadanaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jenis-reksadanas} : get all the jenisReksadanas.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jenisReksadanas in body.
     */
    @GetMapping("/jenis-reksadanas")
    public List<JenisReksadanaDTO> getAllJenisReksadanas() {
        log.debug("REST request to get all JenisReksadanas");
        return jenisReksadanaService.findAll();
    }

    /**
     * {@code GET  /jenis-reksadanas/:id} : get the "id" jenisReksadana.
     *
     * @param id the id of the jenisReksadanaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jenisReksadanaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jenis-reksadanas/{id}")
    public ResponseEntity<JenisReksadanaDTO> getJenisReksadana(@PathVariable Long id) {
        log.debug("REST request to get JenisReksadana : {}", id);
        Optional<JenisReksadanaDTO> jenisReksadanaDTO = jenisReksadanaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jenisReksadanaDTO);
    }

    /**
     * {@code DELETE  /jenis-reksadanas/:id} : delete the "id" jenisReksadana.
     *
     * @param id the id of the jenisReksadanaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jenis-reksadanas/{id}")
    public ResponseEntity<Void> deleteJenisReksadana(@PathVariable Long id) {
        log.debug("REST request to delete JenisReksadana : {}", id);
        jenisReksadanaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
