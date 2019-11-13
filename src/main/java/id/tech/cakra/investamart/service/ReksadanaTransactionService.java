package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.ReksadanaTransaction}.
 */
public interface ReksadanaTransactionService {

    /**
     * Save a reksadanaTransaction.
     *
     * @param reksadanaTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    ReksadanaTransactionDTO save(ReksadanaTransactionDTO reksadanaTransactionDTO);

    /**
     * Get all the reksadanaTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReksadanaTransactionDTO> findAll(Pageable pageable);


    /**
     * Get the "id" reksadanaTransaction.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReksadanaTransactionDTO> findOne(Long id);

    /**
     * Delete the "id" reksadanaTransaction.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
