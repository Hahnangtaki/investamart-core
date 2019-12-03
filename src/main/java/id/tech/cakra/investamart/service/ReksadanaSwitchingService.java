package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.ReksadanaSwitching}.
 */
public interface ReksadanaSwitchingService {

    /**
     * Save a reksadanaSwitching.
     *
     * @param reksadanaSwitchingDTO the entity to save.
     * @return the persisted entity.
     */
    ReksadanaSwitchingDTO save(ReksadanaSwitchingDTO reksadanaSwitchingDTO);

    /**
     * Get all the reksadanaSwitchings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<ReksadanaSwitchingDTO> findAll(Pageable pageable);
    /**
     * Get all the ReksadanaSwitchingDTO where Buy is {@code null}.
     *
     * @return the list of entities.
     */
    List<ReksadanaSwitchingDTO> findAllWhereBuyIsNull();
    /**
     * Get all the ReksadanaSwitchingDTO where Sell is {@code null}.
     *
     * @return the list of entities.
     */
    List<ReksadanaSwitchingDTO> findAllWhereSellIsNull();


    /**
     * Get the "id" reksadanaSwitching.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReksadanaSwitchingDTO> findOne(Long id);

    /**
     * Delete the "id" reksadanaSwitching.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
