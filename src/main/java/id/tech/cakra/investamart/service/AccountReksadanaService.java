package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.AccountReksadanaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.AccountReksadana}.
 */
public interface AccountReksadanaService {

    /**
     * Save a accountReksadana.
     *
     * @param accountReksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    AccountReksadanaDTO save(AccountReksadanaDTO accountReksadanaDTO);

    /**
     * Get all the accountReksadanas.
     *
     * @return the list of entities.
     */
    List<AccountReksadanaDTO> findAll();


    /**
     * Get the "id" accountReksadana.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AccountReksadanaDTO> findOne(Long id);

    /**
     * Delete the "id" accountReksadana.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
