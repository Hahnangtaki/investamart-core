package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.ReksadanaSwitchingService;
import id.tech.cakra.investamart.domain.ReksadanaSwitching;
import id.tech.cakra.investamart.repository.ReksadanaSwitchingRepository;
import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaSwitchingMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ReksadanaSwitching}.
 */
@Service
@Transactional
public class ReksadanaSwitchingServiceImpl implements ReksadanaSwitchingService {

    private final Logger log = LoggerFactory.getLogger(ReksadanaSwitchingServiceImpl.class);

    private final ReksadanaSwitchingRepository reksadanaSwitchingRepository;

    private final ReksadanaSwitchingMapper reksadanaSwitchingMapper;

    public ReksadanaSwitchingServiceImpl(ReksadanaSwitchingRepository reksadanaSwitchingRepository, ReksadanaSwitchingMapper reksadanaSwitchingMapper) {
        this.reksadanaSwitchingRepository = reksadanaSwitchingRepository;
        this.reksadanaSwitchingMapper = reksadanaSwitchingMapper;
    }

    /**
     * Save a reksadanaSwitching.
     *
     * @param reksadanaSwitchingDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReksadanaSwitchingDTO save(ReksadanaSwitchingDTO reksadanaSwitchingDTO) {
        log.debug("Request to save ReksadanaSwitching : {}", reksadanaSwitchingDTO);
        ReksadanaSwitching reksadanaSwitching = reksadanaSwitchingMapper.toEntity(reksadanaSwitchingDTO);
        reksadanaSwitching = reksadanaSwitchingRepository.save(reksadanaSwitching);
        return reksadanaSwitchingMapper.toDto(reksadanaSwitching);
    }

    /**
     * Get all the reksadanaSwitchings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ReksadanaSwitchingDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ReksadanaSwitchings");
        return reksadanaSwitchingRepository.findAll(pageable)
            .map(reksadanaSwitchingMapper::toDto);
    }


    /**
     * Get one reksadanaSwitching by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReksadanaSwitchingDTO> findOne(Long id) {
        log.debug("Request to get ReksadanaSwitching : {}", id);
        return reksadanaSwitchingRepository.findById(id)
            .map(reksadanaSwitchingMapper::toDto);
    }

    /**
     * Delete the reksadanaSwitching by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReksadanaSwitching : {}", id);
        reksadanaSwitchingRepository.deleteById(id);
    }
}
