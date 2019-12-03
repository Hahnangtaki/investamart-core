package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.AccountReksadanaService;
import id.tech.cakra.investamart.domain.AccountReksadana;
import id.tech.cakra.investamart.repository.AccountReksadanaRepository;
import id.tech.cakra.investamart.service.dto.AccountReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.AccountReksadanaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link AccountReksadana}.
 */
@Service
@Transactional
public class AccountReksadanaServiceImpl implements AccountReksadanaService {

    private final Logger log = LoggerFactory.getLogger(AccountReksadanaServiceImpl.class);

    private final AccountReksadanaRepository accountReksadanaRepository;

    private final AccountReksadanaMapper accountReksadanaMapper;

    public AccountReksadanaServiceImpl(AccountReksadanaRepository accountReksadanaRepository, AccountReksadanaMapper accountReksadanaMapper) {
        this.accountReksadanaRepository = accountReksadanaRepository;
        this.accountReksadanaMapper = accountReksadanaMapper;
    }

    /**
     * Save a accountReksadana.
     *
     * @param accountReksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public AccountReksadanaDTO save(AccountReksadanaDTO accountReksadanaDTO) {
        log.debug("Request to save AccountReksadana : {}", accountReksadanaDTO);
        AccountReksadana accountReksadana = accountReksadanaMapper.toEntity(accountReksadanaDTO);
        accountReksadana = accountReksadanaRepository.save(accountReksadana);
        return accountReksadanaMapper.toDto(accountReksadana);
    }

    /**
     * Get all the accountReksadanas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<AccountReksadanaDTO> findAll() {
        log.debug("Request to get all AccountReksadanas");
        return accountReksadanaRepository.findAll().stream()
            .map(accountReksadanaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one accountReksadana by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<AccountReksadanaDTO> findOne(Long id) {
        log.debug("Request to get AccountReksadana : {}", id);
        return accountReksadanaRepository.findById(id)
            .map(accountReksadanaMapper::toDto);
    }

    /**
     * Delete the accountReksadana by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AccountReksadana : {}", id);
        accountReksadanaRepository.deleteById(id);
    }
}
