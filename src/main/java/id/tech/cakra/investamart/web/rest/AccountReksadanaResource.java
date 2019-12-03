package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.AccountReksadanaService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.AccountReksadanaDTO;

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
 * REST controller for managing {@link id.tech.cakra.investamart.domain.AccountReksadana}.
 */
@RestController
@RequestMapping("/api")
public class AccountReksadanaResource {

    private final Logger log = LoggerFactory.getLogger(AccountReksadanaResource.class);

    private static final String ENTITY_NAME = "investacoresvcAccountReksadana";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccountReksadanaService accountReksadanaService;

    public AccountReksadanaResource(AccountReksadanaService accountReksadanaService) {
        this.accountReksadanaService = accountReksadanaService;
    }

    /**
     * {@code POST  /account-reksadanas} : Create a new accountReksadana.
     *
     * @param accountReksadanaDTO the accountReksadanaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accountReksadanaDTO, or with status {@code 400 (Bad Request)} if the accountReksadana has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/account-reksadanas")
    public ResponseEntity<AccountReksadanaDTO> createAccountReksadana(@RequestBody AccountReksadanaDTO accountReksadanaDTO) throws URISyntaxException {
        log.debug("REST request to save AccountReksadana : {}", accountReksadanaDTO);
        if (accountReksadanaDTO.getId() != null) {
            throw new BadRequestAlertException("A new accountReksadana cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountReksadanaDTO result = accountReksadanaService.save(accountReksadanaDTO);
        return ResponseEntity.created(new URI("/api/account-reksadanas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /account-reksadanas} : Updates an existing accountReksadana.
     *
     * @param accountReksadanaDTO the accountReksadanaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accountReksadanaDTO,
     * or with status {@code 400 (Bad Request)} if the accountReksadanaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accountReksadanaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/account-reksadanas")
    public ResponseEntity<AccountReksadanaDTO> updateAccountReksadana(@RequestBody AccountReksadanaDTO accountReksadanaDTO) throws URISyntaxException {
        log.debug("REST request to update AccountReksadana : {}", accountReksadanaDTO);
        if (accountReksadanaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountReksadanaDTO result = accountReksadanaService.save(accountReksadanaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, accountReksadanaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /account-reksadanas} : get all the accountReksadanas.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accountReksadanas in body.
     */
    @GetMapping("/account-reksadanas")
    public List<AccountReksadanaDTO> getAllAccountReksadanas() {
        log.debug("REST request to get all AccountReksadanas");
        return accountReksadanaService.findAll();
    }

    /**
     * {@code GET  /account-reksadanas/:id} : get the "id" accountReksadana.
     *
     * @param id the id of the accountReksadanaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accountReksadanaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/account-reksadanas/{id}")
    public ResponseEntity<AccountReksadanaDTO> getAccountReksadana(@PathVariable Long id) {
        log.debug("REST request to get AccountReksadana : {}", id);
        Optional<AccountReksadanaDTO> accountReksadanaDTO = accountReksadanaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountReksadanaDTO);
    }

    /**
     * {@code DELETE  /account-reksadanas/:id} : delete the "id" accountReksadana.
     *
     * @param id the id of the accountReksadanaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/account-reksadanas/{id}")
    public ResponseEntity<Void> deleteAccountReksadana(@PathVariable Long id) {
        log.debug("REST request to delete AccountReksadana : {}", id);
        accountReksadanaService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
