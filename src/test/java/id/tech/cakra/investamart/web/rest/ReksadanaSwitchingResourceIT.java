package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.ReksadanaSwitching;
import id.tech.cakra.investamart.repository.ReksadanaSwitchingRepository;
import id.tech.cakra.investamart.service.ReksadanaSwitchingService;
import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaSwitchingMapper;
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
 * Integration tests for the {@link ReksadanaSwitchingResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class ReksadanaSwitchingResourceIT {

    private static final String DEFAULT_ORDER_NO = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_NO = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_ORDER_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ORDER_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_APPROVE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_APPROVE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_CHARGES = new BigDecimal(1);
    private static final BigDecimal UPDATED_CHARGES = new BigDecimal(2);

    private static final BigDecimal DEFAULT_NET_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_NET_AMOUNT = new BigDecimal(2);

    private static final String DEFAULT_STATUS = "A";
    private static final String UPDATED_STATUS = "B";

    private static final Long DEFAULT_ACCOUNT_ID = 1L;
    private static final Long UPDATED_ACCOUNT_ID = 2L;

    private static final Long DEFAULT_CURRENCY_ID = 1L;
    private static final Long UPDATED_CURRENCY_ID = 2L;

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
    private ReksadanaSwitchingRepository reksadanaSwitchingRepository;

    @Autowired
    private ReksadanaSwitchingMapper reksadanaSwitchingMapper;

    @Autowired
    private ReksadanaSwitchingService reksadanaSwitchingService;

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

    private MockMvc restReksadanaSwitchingMockMvc;

    private ReksadanaSwitching reksadanaSwitching;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReksadanaSwitchingResource reksadanaSwitchingResource = new ReksadanaSwitchingResource(reksadanaSwitchingService);
        this.restReksadanaSwitchingMockMvc = MockMvcBuilders.standaloneSetup(reksadanaSwitchingResource)
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
    public static ReksadanaSwitching createEntity(EntityManager em) {
        ReksadanaSwitching reksadanaSwitching = new ReksadanaSwitching()
            .orderNo(DEFAULT_ORDER_NO)
            .orderTime(DEFAULT_ORDER_TIME)
            .approveTime(DEFAULT_APPROVE_TIME)
            .amount(DEFAULT_AMOUNT)
            .charges(DEFAULT_CHARGES)
            .netAmount(DEFAULT_NET_AMOUNT)
            .status(DEFAULT_STATUS)
            .accountId(DEFAULT_ACCOUNT_ID)
            .currencyId(DEFAULT_CURRENCY_ID)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return reksadanaSwitching;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReksadanaSwitching createUpdatedEntity(EntityManager em) {
        ReksadanaSwitching reksadanaSwitching = new ReksadanaSwitching()
            .orderNo(UPDATED_ORDER_NO)
            .orderTime(UPDATED_ORDER_TIME)
            .approveTime(UPDATED_APPROVE_TIME)
            .amount(UPDATED_AMOUNT)
            .charges(UPDATED_CHARGES)
            .netAmount(UPDATED_NET_AMOUNT)
            .status(UPDATED_STATUS)
            .accountId(UPDATED_ACCOUNT_ID)
            .currencyId(UPDATED_CURRENCY_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return reksadanaSwitching;
    }

    @BeforeEach
    public void initTest() {
        reksadanaSwitching = createEntity(em);
    }

    @Test
    @Transactional
    public void createReksadanaSwitching() throws Exception {
        int databaseSizeBeforeCreate = reksadanaSwitchingRepository.findAll().size();

        // Create the ReksadanaSwitching
        ReksadanaSwitchingDTO reksadanaSwitchingDTO = reksadanaSwitchingMapper.toDto(reksadanaSwitching);
        restReksadanaSwitchingMockMvc.perform(post("/api/reksadana-switchings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaSwitchingDTO)))
            .andExpect(status().isCreated());

        // Validate the ReksadanaSwitching in the database
        List<ReksadanaSwitching> reksadanaSwitchingList = reksadanaSwitchingRepository.findAll();
        assertThat(reksadanaSwitchingList).hasSize(databaseSizeBeforeCreate + 1);
        ReksadanaSwitching testReksadanaSwitching = reksadanaSwitchingList.get(reksadanaSwitchingList.size() - 1);
        assertThat(testReksadanaSwitching.getOrderNo()).isEqualTo(DEFAULT_ORDER_NO);
        assertThat(testReksadanaSwitching.getOrderTime()).isEqualTo(DEFAULT_ORDER_TIME);
        assertThat(testReksadanaSwitching.getApproveTime()).isEqualTo(DEFAULT_APPROVE_TIME);
        assertThat(testReksadanaSwitching.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testReksadanaSwitching.getCharges()).isEqualTo(DEFAULT_CHARGES);
        assertThat(testReksadanaSwitching.getNetAmount()).isEqualTo(DEFAULT_NET_AMOUNT);
        assertThat(testReksadanaSwitching.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testReksadanaSwitching.getAccountId()).isEqualTo(DEFAULT_ACCOUNT_ID);
        assertThat(testReksadanaSwitching.getCurrencyId()).isEqualTo(DEFAULT_CURRENCY_ID);
        assertThat(testReksadanaSwitching.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaSwitching.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testReksadanaSwitching.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testReksadanaSwitching.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaSwitching.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaSwitching.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createReksadanaSwitchingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = reksadanaSwitchingRepository.findAll().size();

        // Create the ReksadanaSwitching with an existing ID
        reksadanaSwitching.setId(1L);
        ReksadanaSwitchingDTO reksadanaSwitchingDTO = reksadanaSwitchingMapper.toDto(reksadanaSwitching);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReksadanaSwitchingMockMvc.perform(post("/api/reksadana-switchings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaSwitchingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaSwitching in the database
        List<ReksadanaSwitching> reksadanaSwitchingList = reksadanaSwitchingRepository.findAll();
        assertThat(reksadanaSwitchingList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReksadanaSwitchings() throws Exception {
        // Initialize the database
        reksadanaSwitchingRepository.saveAndFlush(reksadanaSwitching);

        // Get all the reksadanaSwitchingList
        restReksadanaSwitchingMockMvc.perform(get("/api/reksadana-switchings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reksadanaSwitching.getId().intValue())))
            .andExpect(jsonPath("$.[*].orderNo").value(hasItem(DEFAULT_ORDER_NO)))
            .andExpect(jsonPath("$.[*].orderTime").value(hasItem(sameInstant(DEFAULT_ORDER_TIME))))
            .andExpect(jsonPath("$.[*].approveTime").value(hasItem(sameInstant(DEFAULT_APPROVE_TIME))))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT.intValue())))
            .andExpect(jsonPath("$.[*].charges").value(hasItem(DEFAULT_CHARGES.intValue())))
            .andExpect(jsonPath("$.[*].netAmount").value(hasItem(DEFAULT_NET_AMOUNT.intValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].accountId").value(hasItem(DEFAULT_ACCOUNT_ID.intValue())))
            .andExpect(jsonPath("$.[*].currencyId").value(hasItem(DEFAULT_CURRENCY_ID.intValue())))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getReksadanaSwitching() throws Exception {
        // Initialize the database
        reksadanaSwitchingRepository.saveAndFlush(reksadanaSwitching);

        // Get the reksadanaSwitching
        restReksadanaSwitchingMockMvc.perform(get("/api/reksadana-switchings/{id}", reksadanaSwitching.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reksadanaSwitching.getId().intValue()))
            .andExpect(jsonPath("$.orderNo").value(DEFAULT_ORDER_NO))
            .andExpect(jsonPath("$.orderTime").value(sameInstant(DEFAULT_ORDER_TIME)))
            .andExpect(jsonPath("$.approveTime").value(sameInstant(DEFAULT_APPROVE_TIME)))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT.intValue()))
            .andExpect(jsonPath("$.charges").value(DEFAULT_CHARGES.intValue()))
            .andExpect(jsonPath("$.netAmount").value(DEFAULT_NET_AMOUNT.intValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.accountId").value(DEFAULT_ACCOUNT_ID.intValue()))
            .andExpect(jsonPath("$.currencyId").value(DEFAULT_CURRENCY_ID.intValue()))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingReksadanaSwitching() throws Exception {
        // Get the reksadanaSwitching
        restReksadanaSwitchingMockMvc.perform(get("/api/reksadana-switchings/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReksadanaSwitching() throws Exception {
        // Initialize the database
        reksadanaSwitchingRepository.saveAndFlush(reksadanaSwitching);

        int databaseSizeBeforeUpdate = reksadanaSwitchingRepository.findAll().size();

        // Update the reksadanaSwitching
        ReksadanaSwitching updatedReksadanaSwitching = reksadanaSwitchingRepository.findById(reksadanaSwitching.getId()).get();
        // Disconnect from session so that the updates on updatedReksadanaSwitching are not directly saved in db
        em.detach(updatedReksadanaSwitching);
        updatedReksadanaSwitching
            .orderNo(UPDATED_ORDER_NO)
            .orderTime(UPDATED_ORDER_TIME)
            .approveTime(UPDATED_APPROVE_TIME)
            .amount(UPDATED_AMOUNT)
            .charges(UPDATED_CHARGES)
            .netAmount(UPDATED_NET_AMOUNT)
            .status(UPDATED_STATUS)
            .accountId(UPDATED_ACCOUNT_ID)
            .currencyId(UPDATED_CURRENCY_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        ReksadanaSwitchingDTO reksadanaSwitchingDTO = reksadanaSwitchingMapper.toDto(updatedReksadanaSwitching);

        restReksadanaSwitchingMockMvc.perform(put("/api/reksadana-switchings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaSwitchingDTO)))
            .andExpect(status().isOk());

        // Validate the ReksadanaSwitching in the database
        List<ReksadanaSwitching> reksadanaSwitchingList = reksadanaSwitchingRepository.findAll();
        assertThat(reksadanaSwitchingList).hasSize(databaseSizeBeforeUpdate);
        ReksadanaSwitching testReksadanaSwitching = reksadanaSwitchingList.get(reksadanaSwitchingList.size() - 1);
        assertThat(testReksadanaSwitching.getOrderNo()).isEqualTo(UPDATED_ORDER_NO);
        assertThat(testReksadanaSwitching.getOrderTime()).isEqualTo(UPDATED_ORDER_TIME);
        assertThat(testReksadanaSwitching.getApproveTime()).isEqualTo(UPDATED_APPROVE_TIME);
        assertThat(testReksadanaSwitching.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testReksadanaSwitching.getCharges()).isEqualTo(UPDATED_CHARGES);
        assertThat(testReksadanaSwitching.getNetAmount()).isEqualTo(UPDATED_NET_AMOUNT);
        assertThat(testReksadanaSwitching.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testReksadanaSwitching.getAccountId()).isEqualTo(UPDATED_ACCOUNT_ID);
        assertThat(testReksadanaSwitching.getCurrencyId()).isEqualTo(UPDATED_CURRENCY_ID);
        assertThat(testReksadanaSwitching.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaSwitching.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testReksadanaSwitching.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testReksadanaSwitching.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaSwitching.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaSwitching.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingReksadanaSwitching() throws Exception {
        int databaseSizeBeforeUpdate = reksadanaSwitchingRepository.findAll().size();

        // Create the ReksadanaSwitching
        ReksadanaSwitchingDTO reksadanaSwitchingDTO = reksadanaSwitchingMapper.toDto(reksadanaSwitching);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReksadanaSwitchingMockMvc.perform(put("/api/reksadana-switchings")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaSwitchingDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaSwitching in the database
        List<ReksadanaSwitching> reksadanaSwitchingList = reksadanaSwitchingRepository.findAll();
        assertThat(reksadanaSwitchingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReksadanaSwitching() throws Exception {
        // Initialize the database
        reksadanaSwitchingRepository.saveAndFlush(reksadanaSwitching);

        int databaseSizeBeforeDelete = reksadanaSwitchingRepository.findAll().size();

        // Delete the reksadanaSwitching
        restReksadanaSwitchingMockMvc.perform(delete("/api/reksadana-switchings/{id}", reksadanaSwitching.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ReksadanaSwitching> reksadanaSwitchingList = reksadanaSwitchingRepository.findAll();
        assertThat(reksadanaSwitchingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
