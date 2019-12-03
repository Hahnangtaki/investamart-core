package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.ReksadanaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.Reksadana}.
 */
public interface ReksadanaService {

    /**
     * Save a reksadana.
     *
     * @param reksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    ReksadanaDTO save(ReksadanaDTO reksadanaDTO);

    /**
     * Get all the reksadanas.
     *
     * @return the list of entities.
     */
    List<ReksadanaDTO> findAll();


    /**
     * Get the "id" reksadana.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReksadanaDTO> findOne(Long id);

    /**
     * Delete the "id" reksadana.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
