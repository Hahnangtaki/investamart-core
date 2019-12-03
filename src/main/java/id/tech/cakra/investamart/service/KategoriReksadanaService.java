package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.KategoriReksadanaDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.KategoriReksadana}.
 */
public interface KategoriReksadanaService {

    /**
     * Save a kategoriReksadana.
     *
     * @param kategoriReksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    KategoriReksadanaDTO save(KategoriReksadanaDTO kategoriReksadanaDTO);

    /**
     * Get all the kategoriReksadanas.
     *
     * @return the list of entities.
     */
    List<KategoriReksadanaDTO> findAll();


    /**
     * Get the "id" kategoriReksadana.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<KategoriReksadanaDTO> findOne(Long id);

    /**
     * Delete the "id" kategoriReksadana.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
