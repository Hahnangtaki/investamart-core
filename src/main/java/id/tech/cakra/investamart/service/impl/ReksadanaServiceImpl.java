package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.ReksadanaService;
import id.tech.cakra.investamart.domain.Reksadana;
import id.tech.cakra.investamart.repository.ReksadanaRepository;
import id.tech.cakra.investamart.service.dto.ReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Reksadana}.
 */
@Service
@Transactional
public class ReksadanaServiceImpl implements ReksadanaService {

    private final Logger log = LoggerFactory.getLogger(ReksadanaServiceImpl.class);

    private final ReksadanaRepository reksadanaRepository;

    private final ReksadanaMapper reksadanaMapper;

    public ReksadanaServiceImpl(ReksadanaRepository reksadanaRepository, ReksadanaMapper reksadanaMapper) {
        this.reksadanaRepository = reksadanaRepository;
        this.reksadanaMapper = reksadanaMapper;
    }

    /**
     * Save a reksadana.
     *
     * @param reksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReksadanaDTO save(ReksadanaDTO reksadanaDTO) {
        log.debug("Request to save Reksadana : {}", reksadanaDTO);
        Reksadana reksadana = reksadanaMapper.toEntity(reksadanaDTO);
        reksadana = reksadanaRepository.save(reksadana);
        return reksadanaMapper.toDto(reksadana);
    }

    /**
     * Get all the reksadanas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReksadanaDTO> findAll() {
        log.debug("Request to get all Reksadanas");
        return reksadanaRepository.findAll().stream()
            .map(reksadanaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one reksadana by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReksadanaDTO> findOne(Long id) {
        log.debug("Request to get Reksadana : {}", id);
        return reksadanaRepository.findById(id)
            .map(reksadanaMapper::toDto);
    }

    /**
     * Delete the reksadana by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reksadana : {}", id);
        reksadanaRepository.deleteById(id);
    }
}
