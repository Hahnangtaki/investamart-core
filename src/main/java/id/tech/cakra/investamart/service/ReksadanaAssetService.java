package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.ReksadanaAssetDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.ReksadanaAsset}.
 */
public interface ReksadanaAssetService {

    /**
     * Save a reksadanaAsset.
     *
     * @param reksadanaAssetDTO the entity to save.
     * @return the persisted entity.
     */
    ReksadanaAssetDTO save(ReksadanaAssetDTO reksadanaAssetDTO);

    /**
     * Get all the reksadanaAssets.
     *
     * @return the list of entities.
     */
    List<ReksadanaAssetDTO> findAll();


    /**
     * Get the "id" reksadanaAsset.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReksadanaAssetDTO> findOne(Long id);

    /**
     * Delete the "id" reksadanaAsset.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
