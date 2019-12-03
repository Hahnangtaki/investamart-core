package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.AccountInstitutionService;
import id.tech.cakra.investamart.domain.AccountInstitution;
import id.tech.cakra.investamart.repository.AccountInstitutionRepository;
import id.tech.cakra.investamart.service.dto.AccountInstitutionDTO;
import id.tech.cakra.investamart.service.mapper.AccountInstitutionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link AccountInstitution}.
 */
@Service
@Transactional
public class AccountInstitutionServiceImpl implements AccountInstitutionService {

    private final Logger log = LoggerFactory.getLogger(AccountInstitutionServiceImpl.class);

    private final AccountInstitutionRepository accountInstitutionRepository;

    private final AccountInstitutionMapper accountInstitutionMapper;

    public AccountInstitutionServiceImpl(AccountInstitutionRepository accountInstitutionRepository, AccountInstitutionMapper accountInstitutionMapper) {
        this.accountInstitutionRepository = accountInstitutionRepository;
        this.accountInstitutionMapper = accountInstitutionMapper;
    }

    /**
     * Save a accountInstitution.
     *
     * @param accountInstitutionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public AccountInstitutionDTO save(AccountInstitutionDTO accountInstitutionDTO) {
        log.debug("Request to save AccountInstitution : {}", accountInstitutionDTO);
        AccountInstitution accountInstitution = accountInstitutionMapper.toEntity(accountInstitutionDTO);
        accountInstitution = accountInstitutionRepository.save(accountInstitution);
        return accountInstitutionMapper.toDto(accountInstitution);
    }

    /**
     * Get all the accountInstitutions.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<AccountInstitutionDTO> findAll() {
        log.debug("Request to get all AccountInstitutions");
        return accountInstitutionRepository.findAll().stream()
            .map(accountInstitutionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one accountInstitution by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountInstitutionDTO> findOne(Long id) {
        log.debug("Request to get AccountInstitution : {}", id);
        return accountInstitutionRepository.findById(id)
            .map(accountInstitutionMapper::toDto);
    }

    /**
     * Delete the accountInstitution by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountInstitution : {}", id);
        accountInstitutionRepository.deleteById(id);
    }
}
