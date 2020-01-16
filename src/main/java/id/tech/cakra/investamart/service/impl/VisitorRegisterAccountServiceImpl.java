package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.VisitorRegisterAccountService;
import id.tech.cakra.investamart.domain.VisitorRegisterAccount;
import id.tech.cakra.investamart.repository.VisitorRegisterAccountRepository;
import id.tech.cakra.investamart.service.dto.VisitorRegisterAccountDTO;
import id.tech.cakra.investamart.service.mapper.VisitorRegisterAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link VisitorRegisterAccount}.
 */
@Service
@Transactional
public class VisitorRegisterAccountServiceImpl implements VisitorRegisterAccountService {

    private final Logger log = LoggerFactory.getLogger(VisitorRegisterAccountServiceImpl.class);

    private final VisitorRegisterAccountRepository visitorRegisterAccountRepository;

    private final VisitorRegisterAccountMapper visitorRegisterAccountMapper;

    public VisitorRegisterAccountServiceImpl(VisitorRegisterAccountRepository visitorRegisterAccountRepository, VisitorRegisterAccountMapper visitorRegisterAccountMapper) {
        this.visitorRegisterAccountRepository = visitorRegisterAccountRepository;
        this.visitorRegisterAccountMapper = visitorRegisterAccountMapper;
    }

    /**
     * Save a visitorRegisterAccount.
     *
     * @param visitorRegisterAccountDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public VisitorRegisterAccountDTO save(VisitorRegisterAccountDTO visitorRegisterAccountDTO) {
        log.debug("Request to save VisitorRegisterAccount : {}", visitorRegisterAccountDTO);
        VisitorRegisterAccount visitorRegisterAccount = visitorRegisterAccountMapper.toEntity(visitorRegisterAccountDTO);
        visitorRegisterAccount = visitorRegisterAccountRepository.save(visitorRegisterAccount);
        return visitorRegisterAccountMapper.toDto(visitorRegisterAccount);
    }

    /**
     * Get all the visitorRegisterAccounts.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<VisitorRegisterAccountDTO> findAll() {
        log.debug("Request to get all VisitorRegisterAccounts");
        return visitorRegisterAccountRepository.findAll().stream()
            .map(visitorRegisterAccountMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one visitorRegisterAccount by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<VisitorRegisterAccountDTO> findOne(Long id) {
        log.debug("Request to get VisitorRegisterAccount : {}", id);
        return visitorRegisterAccountRepository.findById(id)
            .map(visitorRegisterAccountMapper::toDto);
    }

    /**
     * Delete the visitorRegisterAccount by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete VisitorRegisterAccount : {}", id);
        visitorRegisterAccountRepository.deleteById(id);
    }
}
