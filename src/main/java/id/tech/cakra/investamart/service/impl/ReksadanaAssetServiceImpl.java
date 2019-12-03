package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.ReksadanaAssetService;
import id.tech.cakra.investamart.domain.ReksadanaAsset;
import id.tech.cakra.investamart.repository.ReksadanaAssetRepository;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaAssetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ReksadanaAsset}.
 */
@Service
@Transactional
public class ReksadanaAssetServiceImpl implements ReksadanaAssetService {

    private final Logger log = LoggerFactory.getLogger(ReksadanaAssetServiceImpl.class);

    private final ReksadanaAssetRepository reksadanaAssetRepository;

    private final ReksadanaAssetMapper reksadanaAssetMapper;

    public ReksadanaAssetServiceImpl(ReksadanaAssetRepository reksadanaAssetRepository, ReksadanaAssetMapper reksadanaAssetMapper) {
        this.reksadanaAssetRepository = reksadanaAssetRepository;
        this.reksadanaAssetMapper = reksadanaAssetMapper;
    }

    /**
     * Save a reksadanaAsset.
     *
     * @param reksadanaAssetDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReksadanaAssetDTO save(ReksadanaAssetDTO reksadanaAssetDTO) {
        log.debug("Request to save ReksadanaAsset : {}", reksadanaAssetDTO);
        ReksadanaAsset reksadanaAsset = reksadanaAssetMapper.toEntity(reksadanaAssetDTO);
        reksadanaAsset = reksadanaAssetRepository.save(reksadanaAsset);
        return reksadanaAssetMapper.toDto(reksadanaAsset);
    }

    /**
     * Get all the reksadanaAssets.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReksadanaAssetDTO> findAll() {
        log.debug("Request to get all ReksadanaAssets");
        return reksadanaAssetRepository.findAll().stream()
            .map(reksadanaAssetMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one reksadanaAsset by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReksadanaAssetDTO> findOne(Long id) {
        log.debug("Request to get ReksadanaAsset : {}", id);
        return reksadanaAssetRepository.findById(id)
            .map(reksadanaAssetMapper::toDto);
    }

    /**
     * Delete the reksadanaAsset by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReksadanaAsset : {}", id);
        reksadanaAssetRepository.deleteById(id);
    }
}
