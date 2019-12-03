package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.AccountMemberService;
import id.tech.cakra.investamart.domain.AccountMember;
import id.tech.cakra.investamart.repository.AccountMemberRepository;
import id.tech.cakra.investamart.service.dto.AccountMemberDTO;
import id.tech.cakra.investamart.service.mapper.AccountMemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service Implementation for managing {@link AccountMember}.
 */
@Service
@Transactional
public class AccountMemberServiceImpl implements AccountMemberService {

    private final Logger log = LoggerFactory.getLogger(AccountMemberServiceImpl.class);

    private final AccountMemberRepository accountMemberRepository;

    private final AccountMemberMapper accountMemberMapper;

    public AccountMemberServiceImpl(AccountMemberRepository accountMemberRepository, AccountMemberMapper accountMemberMapper) {
        this.accountMemberRepository = accountMemberRepository;
        this.accountMemberMapper = accountMemberMapper;
    }

    /**
     * Save a accountMember.
     *
     * @param accountMemberDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public AccountMemberDTO save(AccountMemberDTO accountMemberDTO) {
        log.debug("Request to save AccountMember : {}", accountMemberDTO);
        AccountMember accountMember = accountMemberMapper.toEntity(accountMemberDTO);
        accountMember = accountMemberRepository.save(accountMember);
        return accountMemberMapper.toDto(accountMember);
    }

    /**
     * Get all the accountMembers.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<AccountMemberDTO> findAll() {
        log.debug("Request to get all AccountMembers");
        return accountMemberRepository.findAll().stream()
            .map(accountMemberMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }



    /**
    *  Get all the accountMembers where AccountInstitution is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<AccountMemberDTO> findAllWhereAccountInstitutionIsNull() {
        log.debug("Request to get all accountMembers where AccountInstitution is null");
        return StreamSupport
            .stream(accountMemberRepository.findAll().spliterator(), false)
            .filter(accountMember -> accountMember.getAccountInstitution() == null)
            .map(accountMemberMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
    *  Get all the accountMembers where AccountIndividu is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true) 
    public List<AccountMemberDTO> findAllWhereAccountIndividuIsNull() {
        log.debug("Request to get all accountMembers where AccountIndividu is null");
        return StreamSupport
            .stream(accountMemberRepository.findAll().spliterator(), false)
            .filter(accountMember -> accountMember.getAccountIndividu() == null)
            .map(accountMemberMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one accountMember by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountMemberDTO> findOne(Long id) {
        log.debug("Request to get AccountMember : {}", id);
        return accountMemberRepository.findById(id)
            .map(accountMemberMapper::toDto);
    }

    /**
     * Delete the accountMember by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountMember : {}", id);
        accountMemberRepository.deleteById(id);
    }
}
