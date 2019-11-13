package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.ReksadanaAsset;
import id.tech.cakra.investamart.repository.ReksadanaAssetRepository;
import id.tech.cakra.investamart.service.ReksadanaAssetService;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaAssetMapper;
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
 * Integration tests for the {@link ReksadanaAssetResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class ReksadanaAssetResourceIT {

    private static final LocalDate DEFAULT_VALUE_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_VALUE_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final Double DEFAULT_AUM = 1D;
    private static final Double UPDATED_AUM = 2D;

    private static final Double DEFAULT_UNIT = 1D;
    private static final Double UPDATED_UNIT = 2D;

    private static final Long DEFAULT_REKSADANA_ID = 1L;
    private static final Long UPDATED_REKSADANA_ID = 2L;

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
    private ReksadanaAssetRepository reksadanaAssetRepository;

    @Autowired
    private ReksadanaAssetMapper reksadanaAssetMapper;

    @Autowired
    private ReksadanaAssetService reksadanaAssetService;

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

    private MockMvc restReksadanaAssetMockMvc;

    private ReksadanaAsset reksadanaAsset;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReksadanaAssetResource reksadanaAssetResource = new ReksadanaAssetResource(reksadanaAssetService);
        this.restReksadanaAssetMockMvc = MockMvcBuilders.standaloneSetup(reksadanaAssetResource)
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
    public static ReksadanaAsset createEntity(EntityManager em) {
        ReksadanaAsset reksadanaAsset = new ReksadanaAsset()
            .valueDate(DEFAULT_VALUE_DATE)
            .aum(DEFAULT_AUM)
            .unit(DEFAULT_UNIT)
            .reksadanaId(DEFAULT_REKSADANA_ID)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return reksadanaAsset;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReksadanaAsset createUpdatedEntity(EntityManager em) {
        ReksadanaAsset reksadanaAsset = new ReksadanaAsset()
            .valueDate(UPDATED_VALUE_DATE)
            .aum(UPDATED_AUM)
            .unit(UPDATED_UNIT)
            .reksadanaId(UPDATED_REKSADANA_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return reksadanaAsset;
    }

    @BeforeEach
    public void initTest() {
        reksadanaAsset = createEntity(em);
    }

    @Test
    @Transactional
    public void createReksadanaAsset() throws Exception {
        int databaseSizeBeforeCreate = reksadanaAssetRepository.findAll().size();

        // Create the ReksadanaAsset
        ReksadanaAssetDTO reksadanaAssetDTO = reksadanaAssetMapper.toDto(reksadanaAsset);
        restReksadanaAssetMockMvc.perform(post("/api/reksadana-assets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetDTO)))
            .andExpect(status().isCreated());

        // Validate the ReksadanaAsset in the database
        List<ReksadanaAsset> reksadanaAssetList = reksadanaAssetRepository.findAll();
        assertThat(reksadanaAssetList).hasSize(databaseSizeBeforeCreate + 1);
        ReksadanaAsset testReksadanaAsset = reksadanaAssetList.get(reksadanaAssetList.size() - 1);
        assertThat(testReksadanaAsset.getValueDate()).isEqualTo(DEFAULT_VALUE_DATE);
        assertThat(testReksadanaAsset.getAum()).isEqualTo(DEFAULT_AUM);
        assertThat(testReksadanaAsset.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testReksadanaAsset.getReksadanaId()).isEqualTo(DEFAULT_REKSADANA_ID);
        assertThat(testReksadanaAsset.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaAsset.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testReksadanaAsset.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testReksadanaAsset.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaAsset.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaAsset.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createReksadanaAssetWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = reksadanaAssetRepository.findAll().size();

        // Create the ReksadanaAsset with an existing ID
        reksadanaAsset.setId(1L);
        ReksadanaAssetDTO reksadanaAssetDTO = reksadanaAssetMapper.toDto(reksadanaAsset);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReksadanaAssetMockMvc.perform(post("/api/reksadana-assets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaAsset in the database
        List<ReksadanaAsset> reksadanaAssetList = reksadanaAssetRepository.findAll();
        assertThat(reksadanaAssetList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReksadanaAssets() throws Exception {
        // Initialize the database
        reksadanaAssetRepository.saveAndFlush(reksadanaAsset);

        // Get all the reksadanaAssetList
        restReksadanaAssetMockMvc.perform(get("/api/reksadana-assets?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reksadanaAsset.getId().intValue())))
            .andExpect(jsonPath("$.[*].valueDate").value(hasItem(DEFAULT_VALUE_DATE.toString())))
            .andExpect(jsonPath("$.[*].aum").value(hasItem(DEFAULT_AUM.doubleValue())))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.doubleValue())))
            .andExpect(jsonPath("$.[*].reksadanaId").value(hasItem(DEFAULT_REKSADANA_ID.intValue())))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getReksadanaAsset() throws Exception {
        // Initialize the database
        reksadanaAssetRepository.saveAndFlush(reksadanaAsset);

        // Get the reksadanaAsset
        restReksadanaAssetMockMvc.perform(get("/api/reksadana-assets/{id}", reksadanaAsset.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reksadanaAsset.getId().intValue()))
            .andExpect(jsonPath("$.valueDate").value(DEFAULT_VALUE_DATE.toString()))
            .andExpect(jsonPath("$.aum").value(DEFAULT_AUM.doubleValue()))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.doubleValue()))
            .andExpect(jsonPath("$.reksadanaId").value(DEFAULT_REKSADANA_ID.intValue()))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingReksadanaAsset() throws Exception {
        // Get the reksadanaAsset
        restReksadanaAssetMockMvc.perform(get("/api/reksadana-assets/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReksadanaAsset() throws Exception {
        // Initialize the database
        reksadanaAssetRepository.saveAndFlush(reksadanaAsset);

        int databaseSizeBeforeUpdate = reksadanaAssetRepository.findAll().size();

        // Update the reksadanaAsset
        ReksadanaAsset updatedReksadanaAsset = reksadanaAssetRepository.findById(reksadanaAsset.getId()).get();
        // Disconnect from session so that the updates on updatedReksadanaAsset are not directly saved in db
        em.detach(updatedReksadanaAsset);
        updatedReksadanaAsset
            .valueDate(UPDATED_VALUE_DATE)
            .aum(UPDATED_AUM)
            .unit(UPDATED_UNIT)
            .reksadanaId(UPDATED_REKSADANA_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        ReksadanaAssetDTO reksadanaAssetDTO = reksadanaAssetMapper.toDto(updatedReksadanaAsset);

        restReksadanaAssetMockMvc.perform(put("/api/reksadana-assets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetDTO)))
            .andExpect(status().isOk());

        // Validate the ReksadanaAsset in the database
        List<ReksadanaAsset> reksadanaAssetList = reksadanaAssetRepository.findAll();
        assertThat(reksadanaAssetList).hasSize(databaseSizeBeforeUpdate);
        ReksadanaAsset testReksadanaAsset = reksadanaAssetList.get(reksadanaAssetList.size() - 1);
        assertThat(testReksadanaAsset.getValueDate()).isEqualTo(UPDATED_VALUE_DATE);
        assertThat(testReksadanaAsset.getAum()).isEqualTo(UPDATED_AUM);
        assertThat(testReksadanaAsset.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testReksadanaAsset.getReksadanaId()).isEqualTo(UPDATED_REKSADANA_ID);
        assertThat(testReksadanaAsset.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaAsset.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testReksadanaAsset.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testReksadanaAsset.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaAsset.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaAsset.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingReksadanaAsset() throws Exception {
        int databaseSizeBeforeUpdate = reksadanaAssetRepository.findAll().size();

        // Create the ReksadanaAsset
        ReksadanaAssetDTO reksadanaAssetDTO = reksadanaAssetMapper.toDto(reksadanaAsset);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReksadanaAssetMockMvc.perform(put("/api/reksadana-assets")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaAssetDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaAsset in the database
        List<ReksadanaAsset> reksadanaAssetList = reksadanaAssetRepository.findAll();
        assertThat(reksadanaAssetList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReksadanaAsset() throws Exception {
        // Initialize the database
        reksadanaAssetRepository.saveAndFlush(reksadanaAsset);

        int databaseSizeBeforeDelete = reksadanaAssetRepository.findAll().size();

        // Delete the reksadanaAsset
        restReksadanaAssetMockMvc.perform(delete("/api/reksadana-assets/{id}", reksadanaAsset.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ReksadanaAsset> reksadanaAssetList = reksadanaAssetRepository.findAll();
        assertThat(reksadanaAssetList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
