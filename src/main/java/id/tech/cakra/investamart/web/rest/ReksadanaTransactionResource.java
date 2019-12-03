package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.ReksadanaTransactionService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;

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
 * REST controller for managing {@link id.tech.cakra.investamart.domain.ReksadanaTransaction}.
 */
@RestController
@RequestMapping("/api")
public class ReksadanaTransactionResource {

    private final Logger log = LoggerFactory.getLogger(ReksadanaTransactionResource.class);

    private static final String ENTITY_NAME = "investacoresvcReksadanaTransaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ReksadanaTransactionService reksadanaTransactionService;

    public ReksadanaTransactionResource(ReksadanaTransactionService reksadanaTransactionService) {
        this.reksadanaTransactionService = reksadanaTransactionService;
    }

    /**
     * {@code POST  /reksadana-transactions} : Create a new reksadanaTransaction.
     *
     * @param reksadanaTransactionDTO the reksadanaTransactionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new reksadanaTransactionDTO, or with status {@code 400 (Bad Request)} if the reksadanaTransaction has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/reksadana-transactions")
    public ResponseEntity<ReksadanaTransactionDTO> createReksadanaTransaction(@Valid @RequestBody ReksadanaTransactionDTO reksadanaTransactionDTO) throws URISyntaxException {
        log.debug("REST request to save ReksadanaTransaction : {}", reksadanaTransactionDTO);
        if (reksadanaTransactionDTO.getId() != null) {
            throw new BadRequestAlertException("A new reksadanaTransaction cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ReksadanaTransactionDTO result = reksadanaTransactionService.save(reksadanaTransactionDTO);
        return ResponseEntity.created(new URI("/api/reksadana-transactions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /reksadana-transactions} : Updates an existing reksadanaTransaction.
     *
     * @param reksadanaTransactionDTO the reksadanaTransactionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated reksadanaTransactionDTO,
     * or with status {@code 400 (Bad Request)} if the reksadanaTransactionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the reksadanaTransactionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/reksadana-transactions")
    public ResponseEntity<ReksadanaTransactionDTO> updateReksadanaTransaction(@Valid @RequestBody ReksadanaTransactionDTO reksadanaTransactionDTO) throws URISyntaxException {
        log.debug("REST request to update ReksadanaTransaction : {}", reksadanaTransactionDTO);
        if (reksadanaTransactionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ReksadanaTransactionDTO result = reksadanaTransactionService.save(reksadanaTransactionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, reksadanaTransactionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /reksadana-transactions} : get all the reksadanaTransactions.
     *

     * @param pageable the pagination information.

     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of reksadanaTransactions in body.
     */
    @GetMapping("/reksadana-transactions")
    public ResponseEntity<List<ReksadanaTransactionDTO>> getAllReksadanaTransactions(Pageable pageable, @RequestParam(required = false) String filter) {
        if ("buy-is-null".equals(filter)) {
            log.debug("REST request to get all ReksadanaTransactions where buy is null");
            return new ResponseEntity<>(reksadanaTransactionService.findAllWhereBuyIsNull(),
                    HttpStatus.OK);
        }
        if ("sell-is-null".equals(filter)) {
            log.debug("REST request to get all ReksadanaTransactions where sell is null");
            return new ResponseEntity<>(reksadanaTransactionService.findAllWhereSellIsNull(),
                    HttpStatus.OK);
        }
        log.debug("REST request to get a page of ReksadanaTransactions");
        Page<ReksadanaTransactionDTO> page = reksadanaTransactionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /reksadana-transactions/:id} : get the "id" reksadanaTransaction.
     *
     * @param id the id of the reksadanaTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the reksadanaTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/reksadana-transactions/{id}")
    public ResponseEntity<ReksadanaTransactionDTO> getReksadanaTransaction(@PathVariable Long id) {
        log.debug("REST request to get ReksadanaTransaction : {}", id);
        Optional<ReksadanaTransactionDTO> reksadanaTransactionDTO = reksadanaTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(reksadanaTransactionDTO);
    }

    /**
     * {@code DELETE  /reksadana-transactions/:id} : delete the "id" reksadanaTransaction.
     *
     * @param id the id of the reksadanaTransactionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/reksadana-transactions/{id}")
    public ResponseEntity<Void> deleteReksadanaTransaction(@PathVariable Long id) {
        log.debug("REST request to delete ReksadanaTransaction : {}", id);
        reksadanaTransactionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
