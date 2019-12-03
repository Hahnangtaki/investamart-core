package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.AccountMemberService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.AccountMemberDTO;

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
import java.util.stream.StreamSupport;

/**
 * REST controller for managing {@link id.tech.cakra.investamart.domain.AccountMember}.
 */
@RestController
@RequestMapping("/api")
public class AccountMemberResource {

    private final Logger log = LoggerFactory.getLogger(AccountMemberResource.class);

    private static final String ENTITY_NAME = "investacoresvcAccountMember";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccountMemberService accountMemberService;

    public AccountMemberResource(AccountMemberService accountMemberService) {
        this.accountMemberService = accountMemberService;
    }

    /**
     * {@code POST  /account-members} : Create a new accountMember.
     *
     * @param accountMemberDTO the accountMemberDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accountMemberDTO, or with status {@code 400 (Bad Request)} if the accountMember has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/account-members")
    public ResponseEntity<AccountMemberDTO> createAccountMember(@Valid @RequestBody AccountMemberDTO accountMemberDTO) throws URISyntaxException {
        log.debug("REST request to save AccountMember : {}", accountMemberDTO);
        if (accountMemberDTO.getId() != null) {
            throw new BadRequestAlertException("A new accountMember cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountMemberDTO result = accountMemberService.save(accountMemberDTO);
        return ResponseEntity.created(new URI("/api/account-members/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /account-members} : Updates an existing accountMember.
     *
     * @param accountMemberDTO the accountMemberDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accountMemberDTO,
     * or with status {@code 400 (Bad Request)} if the accountMemberDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accountMemberDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/account-members")
    public ResponseEntity<AccountMemberDTO> updateAccountMember(@Valid @RequestBody AccountMemberDTO accountMemberDTO) throws URISyntaxException {
        log.debug("REST request to update AccountMember : {}", accountMemberDTO);
        if (accountMemberDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountMemberDTO result = accountMemberService.save(accountMemberDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, accountMemberDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /account-members} : get all the accountMembers.
     *

     * @param filter the filter of the request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accountMembers in body.
     */
    @GetMapping("/account-members")
    public List<AccountMemberDTO> getAllAccountMembers(@RequestParam(required = false) String filter) {
        if ("accountinstitution-is-null".equals(filter)) {
            log.debug("REST request to get all AccountMembers where accountInstitution is null");
            return accountMemberService.findAllWhereAccountInstitutionIsNull();
        }
        if ("accountindividu-is-null".equals(filter)) {
            log.debug("REST request to get all AccountMembers where accountIndividu is null");
            return accountMemberService.findAllWhereAccountIndividuIsNull();
        }
        log.debug("REST request to get all AccountMembers");
        return accountMemberService.findAll();
    }

    /**
     * {@code GET  /account-members/:id} : get the "id" accountMember.
     *
     * @param id the id of the accountMemberDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accountMemberDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/account-members/{id}")
    public ResponseEntity<AccountMemberDTO> getAccountMember(@PathVariable Long id) {
        log.debug("REST request to get AccountMember : {}", id);
        Optional<AccountMemberDTO> accountMemberDTO = accountMemberService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountMemberDTO);
    }

    /**
     * {@code DELETE  /account-members/:id} : delete the "id" accountMember.
     *
     * @param id the id of the accountMemberDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/account-members/{id}")
    public ResponseEntity<Void> deleteAccountMember(@PathVariable Long id) {
        log.debug("REST request to delete AccountMember : {}", id);
        accountMemberService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
