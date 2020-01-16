package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.VisitorRegisterAccountDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.VisitorRegisterAccount}.
 */
public interface VisitorRegisterAccountService {

    /**
     * Save a visitorRegisterAccount.
     *
     * @param visitorRegisterAccountDTO the entity to save.
     * @return the persisted entity.
     */
    VisitorRegisterAccountDTO save(VisitorRegisterAccountDTO visitorRegisterAccountDTO);

    /**
     * Get all the visitorRegisterAccounts.
     *
     * @return the list of entities.
     */
    List<VisitorRegisterAccountDTO> findAll();


    /**
     * Get the "id" visitorRegisterAccount.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VisitorRegisterAccountDTO> findOne(Long id);

    /**
     * Delete the "id" visitorRegisterAccount.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
