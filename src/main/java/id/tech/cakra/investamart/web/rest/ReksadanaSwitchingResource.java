package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.ReksadanaSwitchingService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link id.tech.cakra.investamart.domain.ReksadanaSwitching}.
 */
@RestController
@RequestMapping("/api")
public class ReksadanaSwitchingResource {

    private final Logger log = LoggerFactory.getLogger(ReksadanaSwitchingResource.class);

    private static final String ENTITY_NAME = "investacoresvcReksadanaSwitching";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReksadanaSwitchingService reksadanaSwitchingService;

    public ReksadanaSwitchingResource(ReksadanaSwitchingService reksadanaSwitchingService) {
        this.reksadanaSwitchingService = reksadanaSwitchingService;
    }

    /**
     * {@code POST  /reksadana-switchings} : Create a new reksadanaSwitching.
     *
     * @param reksadanaSwitchingDTO the reksadanaSwitchingDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reksadanaSwitchingDTO, or with status {@code 400 (Bad Request)} if the reksadanaSwitching has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reksadana-switchings")
    public ResponseEntity<ReksadanaSwitchingDTO> createReksadanaSwitching(@Valid @RequestBody ReksadanaSwitchingDTO reksadanaSwitchingDTO) throws URISyntaxException {
        log.debug("REST request to save ReksadanaSwitching : {}", reksadanaSwitchingDTO);
        if (reksadanaSwitchingDTO.getId() != null) {
            throw new BadRequestAlertException("A new reksadanaSwitching cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReksadanaSwitchingDTO result = reksadanaSwitchingService.save(reksadanaSwitchingDTO);
        return ResponseEntity.created(new URI("/api/reksadana-switchings/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reksadana-switchings} : Updates an existing reksadanaSwitching.
     *
     * @param reksadanaSwitchingDTO the reksadanaSwitchingDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reksadanaSwitchingDTO,
     * or with status {@code 400 (Bad Request)} if the reksadanaSwitchingDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reksadanaSwitchingDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reksadana-switchings")
    public ResponseEntity<ReksadanaSwitchingDTO> updateReksadanaSwitching(@Valid @RequestBody ReksadanaSwitchingDTO reksadanaSwitchingDTO) throws URISyntaxException {
        log.debug("REST request to update ReksadanaSwitching : {}", reksadanaSwitchingDTO);
        if (reksadanaSwitchingDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReksadanaSwitchingDTO result = reksadanaSwitchingService.save(reksadanaSwitchingDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reksadanaSwitchingDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reksadana-switchings} : get all the reksadanaSwitchings.
     *

     * @param pageable the pagination information.

     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reksadanaSwitchings in body.
     */
    @GetMapping("/reksadana-switchings")
    public ResponseEntity<List<ReksadanaSwitchingDTO>> getAllReksadanaSwitchings(Pageable pageable, @RequestParam(required = false) String filter) {
        if ("buy-is-null".equals(filter)) {
            log.debug("REST request to get all ReksadanaSwitchings where buy is null");
            return new ResponseEntity<>(reksadanaSwitchingService.findAllWhereBuyIsNull(),
                    HttpStatus.OK);
        }
        if ("sell-is-null".equals(filter)) {
            log.debug("REST request to get all ReksadanaSwitchings where sell is null");
            return new ResponseEntity<>(reksadanaSwitchingService.findAllWhereSellIsNull(),
                    HttpStatus.OK);
        }
        log.debug("REST request to get a page of ReksadanaSwitchings");
        Page<ReksadanaSwitchingDTO> page = reksadanaSwitchingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reksadana-switchings/:id} : get the "id" reksadanaSwitching.
     *
     * @param id the id of the reksadanaSwitchingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reksadanaSwitchingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reksadana-switchings/{id}")
    public ResponseEntity<ReksadanaSwitchingDTO> getReksadanaSwitching(@PathVariable Long id) {
        log.debug("REST request to get ReksadanaSwitching : {}", id);
        Optional<ReksadanaSwitchingDTO> reksadanaSwitchingDTO = reksadanaSwitchingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reksadanaSwitchingDTO);
    }

    /**
     * {@code DELETE  /reksadana-switchings/:id} : delete the "id" reksadanaSwitching.
     *
     * @param id the id of the reksadanaSwitchingDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reksadana-switchings/{id}")
    public ResponseEntity<Void> deleteReksadanaSwitching(@PathVariable Long id) {
        log.debug("REST request to delete ReksadanaSwitching : {}", id);
        reksadanaSwitchingService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
