package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.ReksadanaAssetAllocationDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.ReksadanaAssetAllocation}.
 */
public interface ReksadanaAssetAllocationService {

    /**
     * Save a reksadanaAssetAllocation.
     *
     * @param reksadanaAssetAllocationDTO the entity to save.
     * @return the persisted entity.
     */
    ReksadanaAssetAllocationDTO save(ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO);

    /**
     * Get all the reksadanaAssetAllocations.
     *
     * @return the list of entities.
     */
    List<ReksadanaAssetAllocationDTO> findAll();


    /**
     * Get the "id" reksadanaAssetAllocation.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReksadanaAssetAllocationDTO> findOne(Long id);

    /**
     * Delete the "id" reksadanaAssetAllocation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
