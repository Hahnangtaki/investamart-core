package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.VisitorRegisterAccount;
import id.tech.cakra.investamart.repository.VisitorRegisterAccountRepository;
import id.tech.cakra.investamart.service.VisitorRegisterAccountService;
import id.tech.cakra.investamart.service.dto.VisitorRegisterAccountDTO;
import id.tech.cakra.investamart.service.mapper.VisitorRegisterAccountMapper;
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
 * Integration tests for the {@link VisitorRegisterAccountResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class VisitorRegisterAccountResourceIT {

    private static final String DEFAULT_ACCOUNT_TYPE = "A";
    private static final String UPDATED_ACCOUNT_TYPE = "B";

    private static final Long DEFAULT_REGISTER_ID = 1L;
    private static final Long UPDATED_REGISTER_ID = 2L;

    private static final Long DEFAULT_ACCOUNT_ID = 1L;
    private static final Long UPDATED_ACCOUNT_ID = 2L;

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
    private VisitorRegisterAccountRepository visitorRegisterAccountRepository;

    @Autowired
    private VisitorRegisterAccountMapper visitorRegisterAccountMapper;

    @Autowired
    private VisitorRegisterAccountService visitorRegisterAccountService;

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

    private MockMvc restVisitorRegisterAccountMockMvc;

    private VisitorRegisterAccount visitorRegisterAccount;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final VisitorRegisterAccountResource visitorRegisterAccountResource = new VisitorRegisterAccountResource(visitorRegisterAccountService);
        this.restVisitorRegisterAccountMockMvc = MockMvcBuilders.standaloneSetup(visitorRegisterAccountResource)
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
    public static VisitorRegisterAccount createEntity(EntityManager em) {
        VisitorRegisterAccount visitorRegisterAccount = new VisitorRegisterAccount()
            .accountType(DEFAULT_ACCOUNT_TYPE)
            .registerId(DEFAULT_REGISTER_ID)
            .accountId(DEFAULT_ACCOUNT_ID)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return visitorRegisterAccount;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static VisitorRegisterAccount createUpdatedEntity(EntityManager em) {
        VisitorRegisterAccount visitorRegisterAccount = new VisitorRegisterAccount()
            .accountType(UPDATED_ACCOUNT_TYPE)
            .registerId(UPDATED_REGISTER_ID)
            .accountId(UPDATED_ACCOUNT_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return visitorRegisterAccount;
    }

    @BeforeEach
    public void initTest() {
        visitorRegisterAccount = createEntity(em);
    }

    @Test
    @Transactional
    public void createVisitorRegisterAccount() throws Exception {
        int databaseSizeBeforeCreate = visitorRegisterAccountRepository.findAll().size();

        // Create the VisitorRegisterAccount
        VisitorRegisterAccountDTO visitorRegisterAccountDTO = visitorRegisterAccountMapper.toDto(visitorRegisterAccount);
        restVisitorRegisterAccountMockMvc.perform(post("/api/visitor-register-accounts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visitorRegisterAccountDTO)))
            .andExpect(status().isCreated());

        // Validate the VisitorRegisterAccount in the database
        List<VisitorRegisterAccount> visitorRegisterAccountList = visitorRegisterAccountRepository.findAll();
        assertThat(visitorRegisterAccountList).hasSize(databaseSizeBeforeCreate + 1);
        VisitorRegisterAccount testVisitorRegisterAccount = visitorRegisterAccountList.get(visitorRegisterAccountList.size() - 1);
        assertThat(testVisitorRegisterAccount.getAccountType()).isEqualTo(DEFAULT_ACCOUNT_TYPE);
        assertThat(testVisitorRegisterAccount.getRegisterId()).isEqualTo(DEFAULT_REGISTER_ID);
        assertThat(testVisitorRegisterAccount.getAccountId()).isEqualTo(DEFAULT_ACCOUNT_ID);
        assertThat(testVisitorRegisterAccount.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testVisitorRegisterAccount.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testVisitorRegisterAccount.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testVisitorRegisterAccount.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testVisitorRegisterAccount.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testVisitorRegisterAccount.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createVisitorRegisterAccountWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = visitorRegisterAccountRepository.findAll().size();

        // Create the VisitorRegisterAccount with an existing ID
        visitorRegisterAccount.setId(1L);
        VisitorRegisterAccountDTO visitorRegisterAccountDTO = visitorRegisterAccountMapper.toDto(visitorRegisterAccount);

        // An entity with an existing ID cannot be created, so this API call must fail
        restVisitorRegisterAccountMockMvc.perform(post("/api/visitor-register-accounts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visitorRegisterAccountDTO)))
            .andExpect(status().isBadRequest());

        // Validate the VisitorRegisterAccount in the database
        List<VisitorRegisterAccount> visitorRegisterAccountList = visitorRegisterAccountRepository.findAll();
        assertThat(visitorRegisterAccountList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllVisitorRegisterAccounts() throws Exception {
        // Initialize the database
        visitorRegisterAccountRepository.saveAndFlush(visitorRegisterAccount);

        // Get all the visitorRegisterAccountList
        restVisitorRegisterAccountMockMvc.perform(get("/api/visitor-register-accounts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(visitorRegisterAccount.getId().intValue())))
            .andExpect(jsonPath("$.[*].accountType").value(hasItem(DEFAULT_ACCOUNT_TYPE)))
            .andExpect(jsonPath("$.[*].registerId").value(hasItem(DEFAULT_REGISTER_ID.intValue())))
            .andExpect(jsonPath("$.[*].accountId").value(hasItem(DEFAULT_ACCOUNT_ID.intValue())))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getVisitorRegisterAccount() throws Exception {
        // Initialize the database
        visitorRegisterAccountRepository.saveAndFlush(visitorRegisterAccount);

        // Get the visitorRegisterAccount
        restVisitorRegisterAccountMockMvc.perform(get("/api/visitor-register-accounts/{id}", visitorRegisterAccount.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(visitorRegisterAccount.getId().intValue()))
            .andExpect(jsonPath("$.accountType").value(DEFAULT_ACCOUNT_TYPE))
            .andExpect(jsonPath("$.registerId").value(DEFAULT_REGISTER_ID.intValue()))
            .andExpect(jsonPath("$.accountId").value(DEFAULT_ACCOUNT_ID.intValue()))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingVisitorRegisterAccount() throws Exception {
        // Get the visitorRegisterAccount
        restVisitorRegisterAccountMockMvc.perform(get("/api/visitor-register-accounts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateVisitorRegisterAccount() throws Exception {
        // Initialize the database
        visitorRegisterAccountRepository.saveAndFlush(visitorRegisterAccount);

        int databaseSizeBeforeUpdate = visitorRegisterAccountRepository.findAll().size();

        // Update the visitorRegisterAccount
        VisitorRegisterAccount updatedVisitorRegisterAccount = visitorRegisterAccountRepository.findById(visitorRegisterAccount.getId()).get();
        // Disconnect from session so that the updates on updatedVisitorRegisterAccount are not directly saved in db
        em.detach(updatedVisitorRegisterAccount);
        updatedVisitorRegisterAccount
            .accountType(UPDATED_ACCOUNT_TYPE)
            .registerId(UPDATED_REGISTER_ID)
            .accountId(UPDATED_ACCOUNT_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        VisitorRegisterAccountDTO visitorRegisterAccountDTO = visitorRegisterAccountMapper.toDto(updatedVisitorRegisterAccount);

        restVisitorRegisterAccountMockMvc.perform(put("/api/visitor-register-accounts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visitorRegisterAccountDTO)))
            .andExpect(status().isOk());

        // Validate the VisitorRegisterAccount in the database
        List<VisitorRegisterAccount> visitorRegisterAccountList = visitorRegisterAccountRepository.findAll();
        assertThat(visitorRegisterAccountList).hasSize(databaseSizeBeforeUpdate);
        VisitorRegisterAccount testVisitorRegisterAccount = visitorRegisterAccountList.get(visitorRegisterAccountList.size() - 1);
        assertThat(testVisitorRegisterAccount.getAccountType()).isEqualTo(UPDATED_ACCOUNT_TYPE);
        assertThat(testVisitorRegisterAccount.getRegisterId()).isEqualTo(UPDATED_REGISTER_ID);
        assertThat(testVisitorRegisterAccount.getAccountId()).isEqualTo(UPDATED_ACCOUNT_ID);
        assertThat(testVisitorRegisterAccount.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testVisitorRegisterAccount.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testVisitorRegisterAccount.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testVisitorRegisterAccount.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testVisitorRegisterAccount.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testVisitorRegisterAccount.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingVisitorRegisterAccount() throws Exception {
        int databaseSizeBeforeUpdate = visitorRegisterAccountRepository.findAll().size();

        // Create the VisitorRegisterAccount
        VisitorRegisterAccountDTO visitorRegisterAccountDTO = visitorRegisterAccountMapper.toDto(visitorRegisterAccount);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restVisitorRegisterAccountMockMvc.perform(put("/api/visitor-register-accounts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(visitorRegisterAccountDTO)))
            .andExpect(status().isBadRequest());

        // Validate the VisitorRegisterAccount in the database
        List<VisitorRegisterAccount> visitorRegisterAccountList = visitorRegisterAccountRepository.findAll();
        assertThat(visitorRegisterAccountList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteVisitorRegisterAccount() throws Exception {
        // Initialize the database
        visitorRegisterAccountRepository.saveAndFlush(visitorRegisterAccount);

        int databaseSizeBeforeDelete = visitorRegisterAccountRepository.findAll().size();

        // Delete the visitorRegisterAccount
        restVisitorRegisterAccountMockMvc.perform(delete("/api/visitor-register-accounts/{id}", visitorRegisterAccount.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<VisitorRegisterAccount> visitorRegisterAccountList = visitorRegisterAccountRepository.findAll();
        assertThat(visitorRegisterAccountList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
