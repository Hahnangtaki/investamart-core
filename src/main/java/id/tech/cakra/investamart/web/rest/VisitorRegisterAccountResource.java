package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.service.VisitorRegisterAccountService;
import id.tech.cakra.investamart.web.rest.errors.BadRequestAlertException;
import id.tech.cakra.investamart.service.dto.VisitorRegisterAccountDTO;

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
 * REST controller for managing {@link id.tech.cakra.investamart.domain.VisitorRegisterAccount}.
 */
@RestController
@RequestMapping("/api")
public class VisitorRegisterAccountResource {

    private final Logger log = LoggerFactory.getLogger(VisitorRegisterAccountResource.class);

    private static final String ENTITY_NAME = "investacoresvcVisitorRegisterAccount";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VisitorRegisterAccountService visitorRegisterAccountService;

    public VisitorRegisterAccountResource(VisitorRegisterAccountService visitorRegisterAccountService) {
        this.visitorRegisterAccountService = visitorRegisterAccountService;
    }

    /**
     * {@code POST  /visitor-register-accounts} : Create a new visitorRegisterAccount.
     *
     * @param visitorRegisterAccountDTO the visitorRegisterAccountDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new visitorRegisterAccountDTO, or with status {@code 400 (Bad Request)} if the visitorRegisterAccount has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/visitor-register-accounts")
    public ResponseEntity<VisitorRegisterAccountDTO> createVisitorRegisterAccount(@Valid @RequestBody VisitorRegisterAccountDTO visitorRegisterAccountDTO) throws URISyntaxException {
        log.debug("REST request to save VisitorRegisterAccount : {}", visitorRegisterAccountDTO);
        if (visitorRegisterAccountDTO.getId() != null) {
            throw new BadRequestAlertException("A new visitorRegisterAccount cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VisitorRegisterAccountDTO result = visitorRegisterAccountService.save(visitorRegisterAccountDTO);
        return ResponseEntity.created(new URI("/api/visitor-register-accounts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /visitor-register-accounts} : Updates an existing visitorRegisterAccount.
     *
     * @param visitorRegisterAccountDTO the visitorRegisterAccountDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated visitorRegisterAccountDTO,
     * or with status {@code 400 (Bad Request)} if the visitorRegisterAccountDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the visitorRegisterAccountDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/visitor-register-accounts")
    public ResponseEntity<VisitorRegisterAccountDTO> updateVisitorRegisterAccount(@Valid @RequestBody VisitorRegisterAccountDTO visitorRegisterAccountDTO) throws URISyntaxException {
        log.debug("REST request to update VisitorRegisterAccount : {}", visitorRegisterAccountDTO);
        if (visitorRegisterAccountDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VisitorRegisterAccountDTO result = visitorRegisterAccountService.save(visitorRegisterAccountDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, visitorRegisterAccountDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /visitor-register-accounts} : get all the visitorRegisterAccounts.
     *

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of visitorRegisterAccounts in body.
     */
    @GetMapping("/visitor-register-accounts")
    public List<VisitorRegisterAccountDTO> getAllVisitorRegisterAccounts() {
        log.debug("REST request to get all VisitorRegisterAccounts");
        return visitorRegisterAccountService.findAll();
    }

    /**
     * {@code GET  /visitor-register-accounts/:id} : get the "id" visitorRegisterAccount.
     *
     * @param id the id of the visitorRegisterAccountDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the visitorRegisterAccountDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/visitor-register-accounts/{id}")
    public ResponseEntity<VisitorRegisterAccountDTO> getVisitorRegisterAccount(@PathVariable Long id) {
        log.debug("REST request to get VisitorRegisterAccount : {}", id);
        Optional<VisitorRegisterAccountDTO> visitorRegisterAccountDTO = visitorRegisterAccountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(visitorRegisterAccountDTO);
    }

    /**
     * {@code DELETE  /visitor-register-accounts/:id} : delete the "id" visitorRegisterAccount.
     *
     * @param id the id of the visitorRegisterAccountDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/visitor-register-accounts/{id}")
    public ResponseEntity<Void> deleteVisitorRegisterAccount(@PathVariable Long id) {
        log.debug("REST request to delete VisitorRegisterAccount : {}", id);
        visitorRegisterAccountService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
