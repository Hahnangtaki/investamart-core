package id.tech.cakra.investamart.service;

import id.tech.cakra.investamart.service.dto.AccountMemberDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link id.tech.cakra.investamart.domain.AccountMember}.
 */
public interface AccountMemberService {

    /**
     * Save a accountMember.
     *
     * @param accountMemberDTO the entity to save.
     * @return the persisted entity.
     */
    AccountMemberDTO save(AccountMemberDTO accountMemberDTO);

    /**
     * Get all the accountMembers.
     *
     * @return the list of entities.
     */
    List<AccountMemberDTO> findAll();
    /**
     * Get all the AccountMemberDTO where AccountInstitution is {@code null}.
     *
     * @return the list of entities.
     */
    List<AccountMemberDTO> findAllWhereAccountInstitutionIsNull();
    /**
     * Get all the AccountMemberDTO where AccountIndividu is {@code null}.
     *
     * @return the list of entities.
     */
    List<AccountMemberDTO> findAllWhereAccountIndividuIsNull();


    /**
     * Get the "id" accountMember.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AccountMemberDTO> findOne(Long id);

    /**
     * Delete the "id" accountMember.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
