package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.KategoriReksadanaService;
import id.tech.cakra.investamart.domain.KategoriReksadana;
import id.tech.cakra.investamart.repository.KategoriReksadanaRepository;
import id.tech.cakra.investamart.service.dto.KategoriReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.KategoriReksadanaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link KategoriReksadana}.
 */
@Service
@Transactional
public class KategoriReksadanaServiceImpl implements KategoriReksadanaService {

    private final Logger log = LoggerFactory.getLogger(KategoriReksadanaServiceImpl.class);

    private final KategoriReksadanaRepository kategoriReksadanaRepository;

    private final KategoriReksadanaMapper kategoriReksadanaMapper;

    public KategoriReksadanaServiceImpl(KategoriReksadanaRepository kategoriReksadanaRepository, KategoriReksadanaMapper kategoriReksadanaMapper) {
        this.kategoriReksadanaRepository = kategoriReksadanaRepository;
        this.kategoriReksadanaMapper = kategoriReksadanaMapper;
    }

    /**
     * Save a kategoriReksadana.
     *
     * @param kategoriReksadanaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public KategoriReksadanaDTO save(KategoriReksadanaDTO kategoriReksadanaDTO) {
        log.debug("Request to save KategoriReksadana : {}", kategoriReksadanaDTO);
        KategoriReksadana kategoriReksadana = kategoriReksadanaMapper.toEntity(kategoriReksadanaDTO);
        kategoriReksadana = kategoriReksadanaRepository.save(kategoriReksadana);
        return kategoriReksadanaMapper.toDto(kategoriReksadana);
    }

    /**
     * Get all the kategoriReksadanas.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<KategoriReksadanaDTO> findAll() {
        log.debug("Request to get all KategoriReksadanas");
        return kategoriReksadanaRepository.findAll().stream()
            .map(kategoriReksadanaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one kategoriReksadana by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<KategoriReksadanaDTO> findOne(Long id) {
        log.debug("Request to get KategoriReksadana : {}", id);
        return kategoriReksadanaRepository.findById(id)
            .map(kategoriReksadanaMapper::toDto);
    }

    /**
     * Delete the kategoriReksadana by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete KategoriReksadana : {}", id);
        kategoriReksadanaRepository.deleteById(id);
    }
}
