package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.AccountReksadana;
import id.tech.cakra.investamart.repository.AccountReksadanaRepository;
import id.tech.cakra.investamart.service.AccountReksadanaService;
import id.tech.cakra.investamart.service.dto.AccountReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.AccountReksadanaMapper;
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
import java.util.List;

import static id.tech.cakra.investamart.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AccountReksadanaResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class AccountReksadanaResourceIT {

    private static final BigDecimal DEFAULT_COST_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_COST_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_QTY_ON_HAND = new BigDecimal(1);
    private static final BigDecimal UPDATED_QTY_ON_HAND = new BigDecimal(2);

    private static final BigDecimal DEFAULT_QTY_DEPOSIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_QTY_DEPOSIT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_QTY_WITHDRAW = new BigDecimal(1);
    private static final BigDecimal UPDATED_QTY_WITHDRAW = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PROFIT_LOSS = new BigDecimal(1);
    private static final BigDecimal UPDATED_PROFIT_LOSS = new BigDecimal(2);

    @Autowired
    private AccountReksadanaRepository accountReksadanaRepository;

    @Autowired
    private AccountReksadanaMapper accountReksadanaMapper;

    @Autowired
    private AccountReksadanaService accountReksadanaService;

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

    private MockMvc restAccountReksadanaMockMvc;

    private AccountReksadana accountReksadana;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AccountReksadanaResource accountReksadanaResource = new AccountReksadanaResource(accountReksadanaService);
        this.restAccountReksadanaMockMvc = MockMvcBuilders.standaloneSetup(accountReksadanaResource)
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
    public static AccountReksadana createEntity(EntityManager em) {
        AccountReksadana accountReksadana = new AccountReksadana()
            .costPrice(DEFAULT_COST_PRICE)
            .qtyOnHand(DEFAULT_QTY_ON_HAND)
            .qtyDeposit(DEFAULT_QTY_DEPOSIT)
            .qtyWithdraw(DEFAULT_QTY_WITHDRAW)
            .profitLoss(DEFAULT_PROFIT_LOSS);
        return accountReksadana;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AccountReksadana createUpdatedEntity(EntityManager em) {
        AccountReksadana accountReksadana = new AccountReksadana()
            .costPrice(UPDATED_COST_PRICE)
            .qtyOnHand(UPDATED_QTY_ON_HAND)
            .qtyDeposit(UPDATED_QTY_DEPOSIT)
            .qtyWithdraw(UPDATED_QTY_WITHDRAW)
            .profitLoss(UPDATED_PROFIT_LOSS);
        return accountReksadana;
    }

    @BeforeEach
    public void initTest() {
        accountReksadana = createEntity(em);
    }

    @Test
    @Transactional
    public void createAccountReksadana() throws Exception {
        int databaseSizeBeforeCreate = accountReksadanaRepository.findAll().size();

        // Create the AccountReksadana
        AccountReksadanaDTO accountReksadanaDTO = accountReksadanaMapper.toDto(accountReksadana);
        restAccountReksadanaMockMvc.perform(post("/api/account-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountReksadanaDTO)))
            .andExpect(status().isCreated());

        // Validate the AccountReksadana in the database
        List<AccountReksadana> accountReksadanaList = accountReksadanaRepository.findAll();
        assertThat(accountReksadanaList).hasSize(databaseSizeBeforeCreate + 1);
        AccountReksadana testAccountReksadana = accountReksadanaList.get(accountReksadanaList.size() - 1);
        assertThat(testAccountReksadana.getCostPrice()).isEqualTo(DEFAULT_COST_PRICE);
        assertThat(testAccountReksadana.getQtyOnHand()).isEqualTo(DEFAULT_QTY_ON_HAND);
        assertThat(testAccountReksadana.getQtyDeposit()).isEqualTo(DEFAULT_QTY_DEPOSIT);
        assertThat(testAccountReksadana.getQtyWithdraw()).isEqualTo(DEFAULT_QTY_WITHDRAW);
        assertThat(testAccountReksadana.getProfitLoss()).isEqualTo(DEFAULT_PROFIT_LOSS);
    }

    @Test
    @Transactional
    public void createAccountReksadanaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = accountReksadanaRepository.findAll().size();

        // Create the AccountReksadana with an existing ID
        accountReksadana.setId(1L);
        AccountReksadanaDTO accountReksadanaDTO = accountReksadanaMapper.toDto(accountReksadana);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAccountReksadanaMockMvc.perform(post("/api/account-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountReksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AccountReksadana in the database
        List<AccountReksadana> accountReksadanaList = accountReksadanaRepository.findAll();
        assertThat(accountReksadanaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAccountReksadanas() throws Exception {
        // Initialize the database
        accountReksadanaRepository.saveAndFlush(accountReksadana);

        // Get all the accountReksadanaList
        restAccountReksadanaMockMvc.perform(get("/api/account-reksadanas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(accountReksadana.getId().intValue())))
            .andExpect(jsonPath("$.[*].costPrice").value(hasItem(DEFAULT_COST_PRICE.intValue())))
            .andExpect(jsonPath("$.[*].qtyOnHand").value(hasItem(DEFAULT_QTY_ON_HAND.intValue())))
            .andExpect(jsonPath("$.[*].qtyDeposit").value(hasItem(DEFAULT_QTY_DEPOSIT.intValue())))
            .andExpect(jsonPath("$.[*].qtyWithdraw").value(hasItem(DEFAULT_QTY_WITHDRAW.intValue())))
            .andExpect(jsonPath("$.[*].profitLoss").value(hasItem(DEFAULT_PROFIT_LOSS.intValue())));
    }
    
    @Test
    @Transactional
    public void getAccountReksadana() throws Exception {
        // Initialize the database
        accountReksadanaRepository.saveAndFlush(accountReksadana);

        // Get the accountReksadana
        restAccountReksadanaMockMvc.perform(get("/api/account-reksadanas/{id}", accountReksadana.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(accountReksadana.getId().intValue()))
            .andExpect(jsonPath("$.costPrice").value(DEFAULT_COST_PRICE.intValue()))
            .andExpect(jsonPath("$.qtyOnHand").value(DEFAULT_QTY_ON_HAND.intValue()))
            .andExpect(jsonPath("$.qtyDeposit").value(DEFAULT_QTY_DEPOSIT.intValue()))
            .andExpect(jsonPath("$.qtyWithdraw").value(DEFAULT_QTY_WITHDRAW.intValue()))
            .andExpect(jsonPath("$.profitLoss").value(DEFAULT_PROFIT_LOSS.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingAccountReksadana() throws Exception {
        // Get the accountReksadana
        restAccountReksadanaMockMvc.perform(get("/api/account-reksadanas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAccountReksadana() throws Exception {
        // Initialize the database
        accountReksadanaRepository.saveAndFlush(accountReksadana);

        int databaseSizeBeforeUpdate = accountReksadanaRepository.findAll().size();

        // Update the accountReksadana
        AccountReksadana updatedAccountReksadana = accountReksadanaRepository.findById(accountReksadana.getId()).get();
        // Disconnect from session so that the updates on updatedAccountReksadana are not directly saved in db
        em.detach(updatedAccountReksadana);
        updatedAccountReksadana
            .costPrice(UPDATED_COST_PRICE)
            .qtyOnHand(UPDATED_QTY_ON_HAND)
            .qtyDeposit(UPDATED_QTY_DEPOSIT)
            .qtyWithdraw(UPDATED_QTY_WITHDRAW)
            .profitLoss(UPDATED_PROFIT_LOSS);
        AccountReksadanaDTO accountReksadanaDTO = accountReksadanaMapper.toDto(updatedAccountReksadana);

        restAccountReksadanaMockMvc.perform(put("/api/account-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountReksadanaDTO)))
            .andExpect(status().isOk());

        // Validate the AccountReksadana in the database
        List<AccountReksadana> accountReksadanaList = accountReksadanaRepository.findAll();
        assertThat(accountReksadanaList).hasSize(databaseSizeBeforeUpdate);
        AccountReksadana testAccountReksadana = accountReksadanaList.get(accountReksadanaList.size() - 1);
        assertThat(testAccountReksadana.getCostPrice()).isEqualTo(UPDATED_COST_PRICE);
        assertThat(testAccountReksadana.getQtyOnHand()).isEqualTo(UPDATED_QTY_ON_HAND);
        assertThat(testAccountReksadana.getQtyDeposit()).isEqualTo(UPDATED_QTY_DEPOSIT);
        assertThat(testAccountReksadana.getQtyWithdraw()).isEqualTo(UPDATED_QTY_WITHDRAW);
        assertThat(testAccountReksadana.getProfitLoss()).isEqualTo(UPDATED_PROFIT_LOSS);
    }

    @Test
    @Transactional
    public void updateNonExistingAccountReksadana() throws Exception {
        int databaseSizeBeforeUpdate = accountReksadanaRepository.findAll().size();

        // Create the AccountReksadana
        AccountReksadanaDTO accountReksadanaDTO = accountReksadanaMapper.toDto(accountReksadana);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAccountReksadanaMockMvc.perform(put("/api/account-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(accountReksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AccountReksadana in the database
        List<AccountReksadana> accountReksadanaList = accountReksadanaRepository.findAll();
        assertThat(accountReksadanaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAccountReksadana() throws Exception {
        // Initialize the database
        accountReksadanaRepository.saveAndFlush(accountReksadana);

        int databaseSizeBeforeDelete = accountReksadanaRepository.findAll().size();

        // Delete the accountReksadana
        restAccountReksadanaMockMvc.perform(delete("/api/account-reksadanas/{id}", accountReksadana.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AccountReksadana> accountReksadanaList = accountReksadanaRepository.findAll();
        assertThat(accountReksadanaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
