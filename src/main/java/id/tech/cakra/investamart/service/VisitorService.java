package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.VisitorDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.Visitor}.
 */
public interface VisitorService {

    /**
     * Save a visitor.
     *
     * @param visitorDTO the entity to save.
     * @return the persisted entity.
     */
    VisitorDTO save(VisitorDTO visitorDTO);

    /**
     * Get all the visitors.
     *
     * @return the list of entities.
     */
    List<VisitorDTO> findAll();
    /**
     * Get all the VisitorDTO where VisitorRegisterAccount is {@code null}.
     *
     * @return the list of entities.
     */
    List<VisitorDTO> findAllWhereVisitorRegisterAccountIsNull();


    /**
     * Get the "id" visitor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VisitorDTO> findOne(Long id);

    /**
     * Delete the "id" visitor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
