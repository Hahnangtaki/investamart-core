package id.tech.cakra.investamart.service.impl;

import id.tech.cakra.investamart.service.ReksadanaAssetAllocationService;
import id.tech.cakra.investamart.domain.ReksadanaAssetAllocation;
import id.tech.cakra.investamart.repository.ReksadanaAssetAllocationRepository;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetAllocationDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaAssetAllocationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link ReksadanaAssetAllocation}.
 */
@Service
@Transactional
public class ReksadanaAssetAllocationServiceImpl implements ReksadanaAssetAllocationService {

    private final Logger log = LoggerFactory.getLogger(ReksadanaAssetAllocationServiceImpl.class);

    private final ReksadanaAssetAllocationRepository reksadanaAssetAllocationRepository;

    private final ReksadanaAssetAllocationMapper reksadanaAssetAllocationMapper;

    public ReksadanaAssetAllocationServiceImpl(ReksadanaAssetAllocationRepository reksadanaAssetAllocationRepository, ReksadanaAssetAllocationMapper reksadanaAssetAllocationMapper) {
        this.reksadanaAssetAllocationRepository = reksadanaAssetAllocationRepository;
        this.reksadanaAssetAllocationMapper = reksadanaAssetAllocationMapper;
    }

    /**
     * Save a reksadanaAssetAllocation.
     *
     * @param reksadanaAssetAllocationDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public ReksadanaAssetAllocationDTO save(ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO) {
        log.debug("Request to save ReksadanaAssetAllocation : {}", reksadanaAssetAllocationDTO);
        ReksadanaAssetAllocation reksadanaAssetAllocation = reksadanaAssetAllocationMapper.toEntity(reksadanaAssetAllocationDTO);
        reksadanaAssetAllocation = reksadanaAssetAllocationRepository.save(reksadanaAssetAllocation);
        return reksadanaAssetAllocationMapper.toDto(reksadanaAssetAllocation);
    }

    /**
     * Get all the reksadanaAssetAllocations.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<ReksadanaAssetAllocationDTO> findAll() {
        log.debug("Request to get all ReksadanaAssetAllocations");
        return reksadanaAssetAllocationRepository.findAll().stream()
            .map(reksadanaAssetAllocationMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one reksadanaAssetAllocation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<ReksadanaAssetAllocationDTO> findOne(Long id) {
        log.debug("Request to get ReksadanaAssetAllocation : {}", id);
        return reksadanaAssetAllocationRepository.findById(id)
            .map(reksadanaAssetAllocationMapper::toDto);
    }

    /**
     * Delete the reksadanaAssetAllocation by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete ReksadanaAssetAllocation : {}", id);
        reksadanaAssetAllocationRepository.deleteById(id);
    }
}
