package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.ReksadanaTransaction;
import id.tech.cakra.investamart.repository.ReksadanaTransactionRepository;
import id.tech.cakra.investamart.service.ReksadanaTransactionService;
import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaTransactionMapper;
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
 * Integration tests for the {@link ReksadanaTransactionResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class ReksadanaTransactionResourceIT {

    private static final String DEFAULT_ORDER_NO = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_NO = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_ORDER_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ORDER_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final ZonedDateTime DEFAULT_APPROVE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_APPROVE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_ORDER_TYPE = "A";
    private static final String UPDATED_ORDER_TYPE = "B";

    private static final Double DEFAULT_UNIT = 1D;
    private static final Double UPDATED_UNIT = 2D;

    private static final Double DEFAULT_AMOUNT = 1D;
    private static final Double UPDATED_AMOUNT = 2D;

    private static final Double DEFAULT_CHARGES = 1D;
    private static final Double UPDATED_CHARGES = 2D;

    private static final Double DEFAULT_NET_AMOUNT = 1D;
    private static final Double UPDATED_NET_AMOUNT = 2D;

    private static final String DEFAULT_STATUS = "A";
    private static final String UPDATED_STATUS = "B";

    private static final Long DEFAULT_ACCOUNT_ID = 1L;
    private static final Long UPDATED_ACCOUNT_ID = 2L;

    private static final Long DEFAULT_REKSADANA_ID = 1L;
    private static final Long UPDATED_REKSADANA_ID = 2L;

    private static final Long DEFAULT_CURRENCY_ID = 1L;
    private static final Long UPDATED_CURRENCY_ID = 2L;

    private static final Long DEFAULT_SWITCH_ORDER_ID = 1L;
    private static final Long UPDATED_SWITCH_ORDER_ID = 2L;

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
    private ReksadanaTransactionRepository reksadanaTransactionRepository;

    @Autowired
    private ReksadanaTransactionMapper reksadanaTransactionMapper;

    @Autowired
    private ReksadanaTransactionService reksadanaTransactionService;

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

    private MockMvc restReksadanaTransactionMockMvc;

    private ReksadanaTransaction reksadanaTransaction;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReksadanaTransactionResource reksadanaTransactionResource = new ReksadanaTransactionResource(reksadanaTransactionService);
        this.restReksadanaTransactionMockMvc = MockMvcBuilders.standaloneSetup(reksadanaTransactionResource)
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
    public static ReksadanaTransaction createEntity(EntityManager em) {
        ReksadanaTransaction reksadanaTransaction = new ReksadanaTransaction()
            .orderNo(DEFAULT_ORDER_NO)
            .orderTime(DEFAULT_ORDER_TIME)
            .approveTime(DEFAULT_APPROVE_TIME)
            .orderType(DEFAULT_ORDER_TYPE)
            .unit(DEFAULT_UNIT)
            .amount(DEFAULT_AMOUNT)
            .charges(DEFAULT_CHARGES)
            .netAmount(DEFAULT_NET_AMOUNT)
            .status(DEFAULT_STATUS)
            .accountId(DEFAULT_ACCOUNT_ID)
            .reksadanaId(DEFAULT_REKSADANA_ID)
            .currencyId(DEFAULT_CURRENCY_ID)
            .switchOrderId(DEFAULT_SWITCH_ORDER_ID)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return reksadanaTransaction;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ReksadanaTransaction createUpdatedEntity(EntityManager em) {
        ReksadanaTransaction reksadanaTransaction = new ReksadanaTransaction()
            .orderNo(UPDATED_ORDER_NO)
            .orderTime(UPDATED_ORDER_TIME)
            .approveTime(UPDATED_APPROVE_TIME)
            .orderType(UPDATED_ORDER_TYPE)
            .unit(UPDATED_UNIT)
            .amount(UPDATED_AMOUNT)
            .charges(UPDATED_CHARGES)
            .netAmount(UPDATED_NET_AMOUNT)
            .status(UPDATED_STATUS)
            .accountId(UPDATED_ACCOUNT_ID)
            .reksadanaId(UPDATED_REKSADANA_ID)
            .currencyId(UPDATED_CURRENCY_ID)
            .switchOrderId(UPDATED_SWITCH_ORDER_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return reksadanaTransaction;
    }

    @BeforeEach
    public void initTest() {
        reksadanaTransaction = createEntity(em);
    }

    @Test
    @Transactional
    public void createReksadanaTransaction() throws Exception {
        int databaseSizeBeforeCreate = reksadanaTransactionRepository.findAll().size();

        // Create the ReksadanaTransaction
        ReksadanaTransactionDTO reksadanaTransactionDTO = reksadanaTransactionMapper.toDto(reksadanaTransaction);
        restReksadanaTransactionMockMvc.perform(post("/api/reksadana-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaTransactionDTO)))
            .andExpect(status().isCreated());

        // Validate the ReksadanaTransaction in the database
        List<ReksadanaTransaction> reksadanaTransactionList = reksadanaTransactionRepository.findAll();
        assertThat(reksadanaTransactionList).hasSize(databaseSizeBeforeCreate + 1);
        ReksadanaTransaction testReksadanaTransaction = reksadanaTransactionList.get(reksadanaTransactionList.size() - 1);
        assertThat(testReksadanaTransaction.getOrderNo()).isEqualTo(DEFAULT_ORDER_NO);
        assertThat(testReksadanaTransaction.getOrderTime()).isEqualTo(DEFAULT_ORDER_TIME);
        assertThat(testReksadanaTransaction.getApproveTime()).isEqualTo(DEFAULT_APPROVE_TIME);
        assertThat(testReksadanaTransaction.getOrderType()).isEqualTo(DEFAULT_ORDER_TYPE);
        assertThat(testReksadanaTransaction.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testReksadanaTransaction.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testReksadanaTransaction.getCharges()).isEqualTo(DEFAULT_CHARGES);
        assertThat(testReksadanaTransaction.getNetAmount()).isEqualTo(DEFAULT_NET_AMOUNT);
        assertThat(testReksadanaTransaction.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testReksadanaTransaction.getAccountId()).isEqualTo(DEFAULT_ACCOUNT_ID);
        assertThat(testReksadanaTransaction.getReksadanaId()).isEqualTo(DEFAULT_REKSADANA_ID);
        assertThat(testReksadanaTransaction.getCurrencyId()).isEqualTo(DEFAULT_CURRENCY_ID);
        assertThat(testReksadanaTransaction.getSwitchOrderId()).isEqualTo(DEFAULT_SWITCH_ORDER_ID);
        assertThat(testReksadanaTransaction.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaTransaction.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testReksadanaTransaction.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testReksadanaTransaction.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaTransaction.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaTransaction.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createReksadanaTransactionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = reksadanaTransactionRepository.findAll().size();

        // Create the ReksadanaTransaction with an existing ID
        reksadanaTransaction.setId(1L);
        ReksadanaTransactionDTO reksadanaTransactionDTO = reksadanaTransactionMapper.toDto(reksadanaTransaction);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReksadanaTransactionMockMvc.perform(post("/api/reksadana-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaTransactionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaTransaction in the database
        List<ReksadanaTransaction> reksadanaTransactionList = reksadanaTransactionRepository.findAll();
        assertThat(reksadanaTransactionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReksadanaTransactions() throws Exception {
        // Initialize the database
        reksadanaTransactionRepository.saveAndFlush(reksadanaTransaction);

        // Get all the reksadanaTransactionList
        restReksadanaTransactionMockMvc.perform(get("/api/reksadana-transactions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reksadanaTransaction.getId().intValue())))
            .andExpect(jsonPath("$.[*].orderNo").value(hasItem(DEFAULT_ORDER_NO)))
            .andExpect(jsonPath("$.[*].orderTime").value(hasItem(sameInstant(DEFAULT_ORDER_TIME))))
            .andExpect(jsonPath("$.[*].approveTime").value(hasItem(sameInstant(DEFAULT_APPROVE_TIME))))
            .andExpect(jsonPath("$.[*].orderType").value(hasItem(DEFAULT_ORDER_TYPE)))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.doubleValue())))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT.doubleValue())))
            .andExpect(jsonPath("$.[*].charges").value(hasItem(DEFAULT_CHARGES.doubleValue())))
            .andExpect(jsonPath("$.[*].netAmount").value(hasItem(DEFAULT_NET_AMOUNT.doubleValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].accountId").value(hasItem(DEFAULT_ACCOUNT_ID.intValue())))
            .andExpect(jsonPath("$.[*].reksadanaId").value(hasItem(DEFAULT_REKSADANA_ID.intValue())))
            .andExpect(jsonPath("$.[*].currencyId").value(hasItem(DEFAULT_CURRENCY_ID.intValue())))
            .andExpect(jsonPath("$.[*].switchOrderId").value(hasItem(DEFAULT_SWITCH_ORDER_ID.intValue())))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getReksadanaTransaction() throws Exception {
        // Initialize the database
        reksadanaTransactionRepository.saveAndFlush(reksadanaTransaction);

        // Get the reksadanaTransaction
        restReksadanaTransactionMockMvc.perform(get("/api/reksadana-transactions/{id}", reksadanaTransaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reksadanaTransaction.getId().intValue()))
            .andExpect(jsonPath("$.orderNo").value(DEFAULT_ORDER_NO))
            .andExpect(jsonPath("$.orderTime").value(sameInstant(DEFAULT_ORDER_TIME)))
            .andExpect(jsonPath("$.approveTime").value(sameInstant(DEFAULT_APPROVE_TIME)))
            .andExpect(jsonPath("$.orderType").value(DEFAULT_ORDER_TYPE))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.doubleValue()))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT.doubleValue()))
            .andExpect(jsonPath("$.charges").value(DEFAULT_CHARGES.doubleValue()))
            .andExpect(jsonPath("$.netAmount").value(DEFAULT_NET_AMOUNT.doubleValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.accountId").value(DEFAULT_ACCOUNT_ID.intValue()))
            .andExpect(jsonPath("$.reksadanaId").value(DEFAULT_REKSADANA_ID.intValue()))
            .andExpect(jsonPath("$.currencyId").value(DEFAULT_CURRENCY_ID.intValue()))
            .andExpect(jsonPath("$.switchOrderId").value(DEFAULT_SWITCH_ORDER_ID.intValue()))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingReksadanaTransaction() throws Exception {
        // Get the reksadanaTransaction
        restReksadanaTransactionMockMvc.perform(get("/api/reksadana-transactions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReksadanaTransaction() throws Exception {
        // Initialize the database
        reksadanaTransactionRepository.saveAndFlush(reksadanaTransaction);

        int databaseSizeBeforeUpdate = reksadanaTransactionRepository.findAll().size();

        // Update the reksadanaTransaction
        ReksadanaTransaction updatedReksadanaTransaction = reksadanaTransactionRepository.findById(reksadanaTransaction.getId()).get();
        // Disconnect from session so that the updates on updatedReksadanaTransaction are not directly saved in db
        em.detach(updatedReksadanaTransaction);
        updatedReksadanaTransaction
            .orderNo(UPDATED_ORDER_NO)
            .orderTime(UPDATED_ORDER_TIME)
            .approveTime(UPDATED_APPROVE_TIME)
            .orderType(UPDATED_ORDER_TYPE)
            .unit(UPDATED_UNIT)
            .amount(UPDATED_AMOUNT)
            .charges(UPDATED_CHARGES)
            .netAmount(UPDATED_NET_AMOUNT)
            .status(UPDATED_STATUS)
            .accountId(UPDATED_ACCOUNT_ID)
            .reksadanaId(UPDATED_REKSADANA_ID)
            .currencyId(UPDATED_CURRENCY_ID)
            .switchOrderId(UPDATED_SWITCH_ORDER_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        ReksadanaTransactionDTO reksadanaTransactionDTO = reksadanaTransactionMapper.toDto(updatedReksadanaTransaction);

        restReksadanaTransactionMockMvc.perform(put("/api/reksadana-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaTransactionDTO)))
            .andExpect(status().isOk());

        // Validate the ReksadanaTransaction in the database
        List<ReksadanaTransaction> reksadanaTransactionList = reksadanaTransactionRepository.findAll();
        assertThat(reksadanaTransactionList).hasSize(databaseSizeBeforeUpdate);
        ReksadanaTransaction testReksadanaTransaction = reksadanaTransactionList.get(reksadanaTransactionList.size() - 1);
        assertThat(testReksadanaTransaction.getOrderNo()).isEqualTo(UPDATED_ORDER_NO);
        assertThat(testReksadanaTransaction.getOrderTime()).isEqualTo(UPDATED_ORDER_TIME);
        assertThat(testReksadanaTransaction.getApproveTime()).isEqualTo(UPDATED_APPROVE_TIME);
        assertThat(testReksadanaTransaction.getOrderType()).isEqualTo(UPDATED_ORDER_TYPE);
        assertThat(testReksadanaTransaction.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testReksadanaTransaction.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testReksadanaTransaction.getCharges()).isEqualTo(UPDATED_CHARGES);
        assertThat(testReksadanaTransaction.getNetAmount()).isEqualTo(UPDATED_NET_AMOUNT);
        assertThat(testReksadanaTransaction.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testReksadanaTransaction.getAccountId()).isEqualTo(UPDATED_ACCOUNT_ID);
        assertThat(testReksadanaTransaction.getReksadanaId()).isEqualTo(UPDATED_REKSADANA_ID);
        assertThat(testReksadanaTransaction.getCurrencyId()).isEqualTo(UPDATED_CURRENCY_ID);
        assertThat(testReksadanaTransaction.getSwitchOrderId()).isEqualTo(UPDATED_SWITCH_ORDER_ID);
        assertThat(testReksadanaTransaction.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testReksadanaTransaction.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testReksadanaTransaction.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testReksadanaTransaction.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadanaTransaction.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testReksadanaTransaction.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingReksadanaTransaction() throws Exception {
        int databaseSizeBeforeUpdate = reksadanaTransactionRepository.findAll().size();

        // Create the ReksadanaTransaction
        ReksadanaTransactionDTO reksadanaTransactionDTO = reksadanaTransactionMapper.toDto(reksadanaTransaction);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReksadanaTransactionMockMvc.perform(put("/api/reksadana-transactions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaTransactionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ReksadanaTransaction in the database
        List<ReksadanaTransaction> reksadanaTransactionList = reksadanaTransactionRepository.findAll();
        assertThat(reksadanaTransactionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReksadanaTransaction() throws Exception {
        // Initialize the database
        reksadanaTransactionRepository.saveAndFlush(reksadanaTransaction);

        int databaseSizeBeforeDelete = reksadanaTransactionRepository.findAll().size();

        // Delete the reksadanaTransaction
        restReksadanaTransactionMockMvc.perform(delete("/api/reksadana-transactions/{id}", reksadanaTransaction.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ReksadanaTransaction> reksadanaTransactionList = reksadanaTransactionRepository.findAll();
        assertThat(reksadanaTransactionList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
