package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.JenisReksadanaService;
import id.tech.cakra.investamart.domain.JenisReksadana;
import id.tech.cakra.investamart.repository.JenisReksadanaRepository;
import id.tech.cakra.investamart.service.dto.JenisReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.JenisReksadanaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link JenisReksadana}.
 */
@Service
@Transactional
public class JenisReksadanaServiceImpl implements JenisReksadanaService {

    private final Logger log = LoggerFactory.getLogger(JenisReksadanaServiceImpl.class);

    private final JenisReksadanaRepository jenisReksadanaRepository;

    private final JenisReksadanaMapper jenisReksadanaMapper;

    public JenisReksadanaServiceImpl(JenisReksadanaRepository jenisReksadanaRepository, JenisReksadanaMapper jenisReksadanaMapper) {
        this.jenisReksadanaRepository = jenisReksadanaRepository;
        this.jenisReksadanaMapper = jenisReksadanaMapper;
    }

    /**
     * Save a jenisReksadana.
     *
     * @param jenisReksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public JenisReksadanaDTO save(JenisReksadanaDTO jenisReksadanaDTO) {
        log.debug("Request to save JenisReksadana : {}", jenisReksadanaDTO);
        JenisReksadana jenisReksadana = jenisReksadanaMapper.toEntity(jenisReksadanaDTO);
        jenisReksadana = jenisReksadanaRepository.save(jenisReksadana);
        return jenisReksadanaMapper.toDto(jenisReksadana);
    }

    /**
     * Get all the jenisReksadanas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<JenisReksadanaDTO> findAll() {
        log.debug("Request to get all JenisReksadanas");
        return jenisReksadanaRepository.findAll().stream()
            .map(jenisReksadanaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one jenisReksadana by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JenisReksadanaDTO> findOne(Long id) {
        log.debug("Request to get JenisReksadana : {}", id);
        return jenisReksadanaRepository.findById(id)
            .map(jenisReksadanaMapper::toDto);
    }

    /**
     * Delete the jenisReksadana by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JenisReksadana : {}", id);
        jenisReksadanaRepository.deleteById(id);
    }
}
