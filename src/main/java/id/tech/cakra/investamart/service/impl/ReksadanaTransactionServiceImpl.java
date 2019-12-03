package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.ReksadanaTransactionService;
import id.tech.cakra.investamart.domain.ReksadanaTransaction;
import id.tech.cakra.investamart.repository.ReksadanaTransactionRepository;
import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaTransactionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ReksadanaTransaction}.
 */
@Service
@Transactional
public class ReksadanaTransactionServiceImpl implements ReksadanaTransactionService {

    private final Logger log = LoggerFactory.getLogger(ReksadanaTransactionServiceImpl.class);

    private final ReksadanaTransactionRepository reksadanaTransactionRepository;

    private final ReksadanaTransactionMapper reksadanaTransactionMapper;

    public ReksadanaTransactionServiceImpl(ReksadanaTransactionRepository reksadanaTransactionRepository, ReksadanaTransactionMapper reksadanaTransactionMapper) {
        this.reksadanaTransactionRepository = reksadanaTransactionRepository;
        this.reksadanaTransactionMapper = reksadanaTransactionMapper;
    }

    /**
     * Save a reksadanaTransaction.
     *
     * @param reksadanaTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReksadanaTransactionDTO save(ReksadanaTransactionDTO reksadanaTransactionDTO) {
        log.debug("Request to save ReksadanaTransaction : {}", reksadanaTransactionDTO);
        ReksadanaTransaction reksadanaTransaction = reksadanaTransactionMapper.toEntity(reksadanaTransactionDTO);
        reksadanaTransaction = reksadanaTransactionRepository.save(reksadanaTransaction);
        return reksadanaTransactionMapper.toDto(reksadanaTransaction);
    }

    /**
     * Get all the reksadanaTransactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReksadanaTransactionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ReksadanaTransactions");
        return reksadanaTransactionRepository.findAll(pageable)
            .map(reksadanaTransactionMapper::toDto);
    }


    /**
     * Get one reksadanaTransaction by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReksadanaTransactionDTO> findOne(Long id) {
        log.debug("Request to get ReksadanaTransaction : {}", id);
        return reksadanaTransactionRepository.findById(id)
            .map(reksadanaTransactionMapper::toDto);
    }

    /**
     * Delete the reksadanaTransaction by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReksadanaTransaction : {}", id);
        reksadanaTransactionRepository.deleteById(id);
    }
}
