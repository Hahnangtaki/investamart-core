package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.JenisReksadanaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.JenisReksadana}.
 */
public interface JenisReksadanaService {

    /**
     * Save a jenisReksadana.
     *
     * @param jenisReksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    JenisReksadanaDTO save(JenisReksadanaDTO jenisReksadanaDTO);

    /**
     * Get all the jenisReksadanas.
     *
     * @return the list of entities.
     */
    List<JenisReksadanaDTO> findAll();


    /**
     * Get the "id" jenisReksadana.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<JenisReksadanaDTO> findOne(Long id);

    /**
     * Delete the "id" jenisReksadana.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
