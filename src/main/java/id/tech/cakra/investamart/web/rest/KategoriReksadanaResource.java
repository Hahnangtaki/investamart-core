package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.KategoriReksadanaService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.KategoriReksadanaDTO;

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
 * REST controller for managing {@link id.tech.cakra.investamart.domain.KategoriReksadana}.
 */
@RestController
@RequestMapping("/api")
public class KategoriReksadanaResource {

    private final Logger log = LoggerFactory.getLogger(KategoriReksadanaResource.class);

    private static final String ENTITY_NAME = "investacoresvcKategoriReksadana";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final KategoriReksadanaService kategoriReksadanaService;

    public KategoriReksadanaResource(KategoriReksadanaService kategoriReksadanaService) {
        this.kategoriReksadanaService = kategoriReksadanaService;
    }

    /**
     * {@code POST  /kategori-reksadanas} : Create a new kategoriReksadana.
     *
     * @param kategoriReksadanaDTO the kategoriReksadanaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new kategoriReksadanaDTO, or with status {@code 400 (Bad Request)} if the kategoriReksadana has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/kategori-reksadanas")
    public ResponseEntity<KategoriReksadanaDTO> createKategoriReksadana(@Valid @RequestBody KategoriReksadanaDTO kategoriReksadanaDTO) throws URISyntaxException {
        log.debug("REST request to save KategoriReksadana : {}", kategoriReksadanaDTO);
        if (kategoriReksadanaDTO.getId() != null) {
            throw new BadRequestAlertException("A new kategoriReksadana cannot already have an ID", ENTITY_NAME, "idexists");
        }
        KategoriReksadanaDTO result = kategoriReksadanaService.save(kategoriReksadanaDTO);
        return ResponseEntity.created(new URI("/api/kategori-reksadanas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /kategori-reksadanas} : Updates an existing kategoriReksadana.
     *
     * @param kategoriReksadanaDTO the kategoriReksadanaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated kategoriReksadanaDTO,
     * or with status {@code 400 (Bad Request)} if the kategoriReksadanaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the kategoriReksadanaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/kategori-reksadanas")
    public ResponseEntity<KategoriReksadanaDTO> updateKategoriReksadana(@Valid @RequestBody KategoriReksadanaDTO kategoriReksadanaDTO) throws URISyntaxException {
        log.debug("REST request to update KategoriReksadana : {}", kategoriReksadanaDTO);
        if (kategoriReksadanaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        KategoriReksadanaDTO result = kategoriReksadanaService.save(kategoriReksadanaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, kategoriReksadanaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /kategori-reksadanas} : get all the kategoriReksadanas.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of kategoriReksadanas in body.
     */
    @GetMapping("/kategori-reksadanas")
    public List<KategoriReksadanaDTO> getAllKategoriReksadanas() {
        log.debug("REST request to get all KategoriReksadanas");
        return kategoriReksadanaService.findAll();
    }

    /**
     * {@code GET  /kategori-reksadanas/:id} : get the "id" kategoriReksadana.
     *
     * @param id the id of the kategoriReksadanaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the kategoriReksadanaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/kategori-reksadanas/{id}")
    public ResponseEntity<KategoriReksadanaDTO> getKategoriReksadana(@PathVariable Long id) {
        log.debug("REST request to get KategoriReksadana : {}", id);
        Optional<KategoriReksadanaDTO> kategoriReksadanaDTO = kategoriReksadanaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(kategoriReksadanaDTO);
    }

    /**
     * {@code DELETE  /kategori-reksadanas/:id} : delete the "id" kategoriReksadana.
     *
     * @param id the id of the kategoriReksadanaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/kategori-reksadanas/{id}")
    public ResponseEntity<Void> deleteKategoriReksadana(@PathVariable Long id) {
        log.debug("REST request to delete KategoriReksadana : {}", id);
        kategoriReksadanaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
