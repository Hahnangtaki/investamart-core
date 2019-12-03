package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.ReksadanaAssetAllocation;
import id.tech.cakra.investamart.repository.ReksadanaAssetAllocationRepository;
import id.tech.cakra.investamart.service.ReksadanaAssetAllocationService;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetAllocationDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaAssetAllocationMapper;
import id.tech.cakra.investamart.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static id.tech.cakra.investamart.web.rest.TestUtil.sameInstant;
import static id.tech.cakra.investamart.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ReksadanaAssetAllocationResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class ReksadanaAssetAllocationResourceIT {

    private static final LocalDate DEFAULT_VALUE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALUE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_INSTRUMENT_TYPE = "A";
    private static final String UPDATED_INSTRUMENT_TYPE = "B";

    private static final BigDecimal DEFAULT_ASSET_VALUE = new BigDecimal(1);
    private static final BigDecimal UPDATED_ASSET_VALUE = new BigDecimal(2);

    private static final LocalDate DEFAULT_CREATE_SYSTEM_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CREATE_SYSTEM_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_CREATE_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Long DEFAULT_CREATE_USER_ID = 1L;
    private static final Long UPDATED_CREATE_USER_ID = 2L;

    private static final LocalDate DEFAULT_LAST_MODIFICATION_SYSTEM_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_MODIFICATION_SYSTEM_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final ZonedDateTime DEFAULT_LAST_MODIFICATION_DATE = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_LAST_MODIFICATION_DATE = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Long DEFAULT_LAST_MODIFICATION_USER_ID = 1L;
    private static final Long UPDATED_LAST_MODIFICATION_USER_ID = 2L;

    @Autowired
    private ReksadanaAssetAllocationRepository reksadanaAssetAllocationRepository;

    @Autowired
    private ReksadanaAssetAllocationMapper reksadanaAssetAllocationMapper;

    @Autowired
    private ReksadanaAssetAllocationService reksadanaAssetAllocationService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restReksadanaAssetAllocationMockMvc;

    private ReksadanaAssetAllocation reksadanaAssetAllocation;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReksadanaAssetAllocationResource reksadanaAssetAllocationResource = new ReksadanaAssetAllocationResource(reksadanaAssetAllocationService);
        this.restReksadanaAssetAllocationMockMvc = MockMvcBuilders.standaloneSetup(reksadanaAssetAllocationResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReksadanaAssetAllocation createEntity(EntityManager em) {
        ReksadanaAssetAllocation reksadanaAssetAllocation = new ReksadanaAssetAllocation()
            .valueDate(DEFAULT_VALUE_DATE)
            .instrumentType(DEFAULT_INSTRUMENT_TYPE)
            .assetValue(DEFAULT_ASSET_VALUE)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return reksadanaAssetAllocation;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReksadanaAssetAllocation createUpdatedEntity(EntityManager em) {
        ReksadanaAssetAllocation reksadanaAssetAllocation = new ReksadanaAssetAllocation()
            .valueDate(UPDATED_VALUE_DATE)
            .instrumentType(UPDATED_INSTRUMENT_TYPE)
            .assetValue(UPDATED_ASSET_VALUE)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return reksadanaAssetAllocation;
    }

    @BeforeEach
    public void initTest() {
        reksadanaAssetAllocation = createEntity(em);
    }

    @Test
    @Transactional
    public void createReksadanaAssetAllocation() throws Exception {
        int databaseSizeBeforeCreate = reksadanaAssetAllocationRepository.findAll().size();

        // Create the ReksadanaAssetAllocation
        ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO = reksadanaAssetAllocationMapper.toDto(reksadanaAssetAllocation);
        restReksadanaAssetAllocationMockMvc.perform(post("/api/reksadana-asset-allocations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetAllocationDTO)))
            .andExpect(status().isCreated());

        // Validate the ReksadanaAssetAllocation in the database
        List<ReksadanaAssetAllocation> reksadanaAssetAllocationList = reksadanaAssetAllocationRepository.findAll();
        assertThat(reksadanaAssetAllocationList).hasSize(databaseSizeBeforeCreate + 1);
        ReksadanaAssetAllocation testReksadanaAssetAllocation = reksadanaAssetAllocationList.get(reksadanaAssetAllocationList.size() - 1);
        assertThat(testReksadanaAssetAllocation.getValueDate()).isEqualTo(DEFAULT_VALUE_DATE);
        assertThat(testReksadanaAssetAllocation.getInstrumentType()).isEqualTo(DEFAULT_INSTRUMENT_TYPE);
        assertThat(testReksadanaAssetAllocation.getAssetValue()).isEqualTo(DEFAULT_ASSET_VALUE);
        assertThat(testReksadanaAssetAllocation.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaAssetAllocation.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testReksadanaAssetAllocation.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testReksadanaAssetAllocation.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaAssetAllocation.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaAssetAllocation.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createReksadanaAssetAllocationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = reksadanaAssetAllocationRepository.findAll().size();

        // Create the ReksadanaAssetAllocation with an existing ID
        reksadanaAssetAllocation.setId(1L);
        ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO = reksadanaAssetAllocationMapper.toDto(reksadanaAssetAllocation);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReksadanaAssetAllocationMockMvc.perform(post("/api/reksadana-asset-allocations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetAllocationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaAssetAllocation in the database
        List<ReksadanaAssetAllocation> reksadanaAssetAllocationList = reksadanaAssetAllocationRepository.findAll();
        assertThat(reksadanaAssetAllocationList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReksadanaAssetAllocations() throws Exception {
        // Initialize the database
        reksadanaAssetAllocationRepository.saveAndFlush(reksadanaAssetAllocation);

        // Get all the reksadanaAssetAllocationList
        restReksadanaAssetAllocationMockMvc.perform(get("/api/reksadana-asset-allocations?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reksadanaAssetAllocation.getId().intValue())))
            .andExpect(jsonPath("$.[*].valueDate").value(hasItem(DEFAULT_VALUE_DATE.toString())))
            .andExpect(jsonPath("$.[*].instrumentType").value(hasItem(DEFAULT_INSTRUMENT_TYPE)))
            .andExpect(jsonPath("$.[*].assetValue").value(hasItem(DEFAULT_ASSET_VALUE.intValue())))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getReksadanaAssetAllocation() throws Exception {
        // Initialize the database
        reksadanaAssetAllocationRepository.saveAndFlush(reksadanaAssetAllocation);

        // Get the reksadanaAssetAllocation
        restReksadanaAssetAllocationMockMvc.perform(get("/api/reksadana-asset-allocations/{id}", reksadanaAssetAllocation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reksadanaAssetAllocation.getId().intValue()))
            .andExpect(jsonPath("$.valueDate").value(DEFAULT_VALUE_DATE.toString()))
            .andExpect(jsonPath("$.instrumentType").value(DEFAULT_INSTRUMENT_TYPE))
            .andExpect(jsonPath("$.assetValue").value(DEFAULT_ASSET_VALUE.intValue()))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingReksadanaAssetAllocation() throws Exception {
        // Get the reksadanaAssetAllocation
        restReksadanaAssetAllocationMockMvc.perform(get("/api/reksadana-asset-allocations/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReksadanaAssetAllocation() throws Exception {
        // Initialize the database
        reksadanaAssetAllocationRepository.saveAndFlush(reksadanaAssetAllocation);

        int databaseSizeBeforeUpdate = reksadanaAssetAllocationRepository.findAll().size();

        // Update the reksadanaAssetAllocation
        ReksadanaAssetAllocation updatedReksadanaAssetAllocation = reksadanaAssetAllocationRepository.findById(reksadanaAssetAllocation.getId()).get();
        // Disconnect from session so that the updates on updatedReksadanaAssetAllocation are not directly saved in db
        em.detach(updatedReksadanaAssetAllocation);
        updatedReksadanaAssetAllocation
            .valueDate(UPDATED_VALUE_DATE)
            .instrumentType(UPDATED_INSTRUMENT_TYPE)
            .assetValue(UPDATED_ASSET_VALUE)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO = reksadanaAssetAllocationMapper.toDto(updatedReksadanaAssetAllocation);

        restReksadanaAssetAllocationMockMvc.perform(put("/api/reksadana-asset-allocations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetAllocationDTO)))
            .andExpect(status().isOk());

        // Validate the ReksadanaAssetAllocation in the database
        List<ReksadanaAssetAllocation> reksadanaAssetAllocationList = reksadanaAssetAllocationRepository.findAll();
        assertThat(reksadanaAssetAllocationList).hasSize(databaseSizeBeforeUpdate);
        ReksadanaAssetAllocation testReksadanaAssetAllocation = reksadanaAssetAllocationList.get(reksadanaAssetAllocationList.size() - 1);
        assertThat(testReksadanaAssetAllocation.getValueDate()).isEqualTo(UPDATED_VALUE_DATE);
        assertThat(testReksadanaAssetAllocation.getInstrumentType()).isEqualTo(UPDATED_INSTRUMENT_TYPE);
        assertThat(testReksadanaAssetAllocation.getAssetValue()).isEqualTo(UPDATED_ASSET_VALUE);
        assertThat(testReksadanaAssetAllocation.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaAssetAllocation.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testReksadanaAssetAllocation.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testReksadanaAssetAllocation.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaAssetAllocation.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaAssetAllocation.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingReksadanaAssetAllocation() throws Exception {
        int databaseSizeBeforeUpdate = reksadanaAssetAllocationRepository.findAll().size();

        // Create the ReksadanaAssetAllocation
        ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO = reksadanaAssetAllocationMapper.toDto(reksadanaAssetAllocation);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReksadanaAssetAllocationMockMvc.perform(put("/api/reksadana-asset-allocations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetAllocationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaAssetAllocation in the database
        List<ReksadanaAssetAllocation> reksadanaAssetAllocationList = reksadanaAssetAllocationRepository.findAll();
        assertThat(reksadanaAssetAllocationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReksadanaAssetAllocation() throws Exception {
        // Initialize the database
        reksadanaAssetAllocationRepository.saveAndFlush(reksadanaAssetAllocation);

        int databaseSizeBeforeDelete = reksadanaAssetAllocationRepository.findAll().size();

        // Delete the reksadanaAssetAllocation
        restReksadanaAssetAllocationMockMvc.perform(delete("/api/reksadana-asset-allocations/{id}", reksadanaAssetAllocation.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ReksadanaAssetAllocation> reksadanaAssetAllocationList = reksadanaAssetAllocationRepository.findAll();
        assertThat(reksadanaAssetAllocationList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
