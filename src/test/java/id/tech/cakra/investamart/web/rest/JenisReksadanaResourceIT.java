package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.JenisReksadana;
import id.tech.cakra.investamart.repository.JenisReksadanaRepository;
import id.tech.cakra.investamart.service.JenisReksadanaService;
import id.tech.cakra.investamart.service.dto.JenisReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.JenisReksadanaMapper;
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
 * Integration tests for the {@link JenisReksadanaResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class JenisReksadanaResourceIT {

    private static final String DEFAULT_KODE_JENIS = "AAAAAAAAAA";
    private static final String UPDATED_KODE_JENIS = "BBBBBBBBBB";

    private static final String DEFAULT_NAMA_JENIS = "AAAAAAAAAA";
    private static final String UPDATED_NAMA_JENIS = "BBBBBBBBBB";

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
    private JenisReksadanaRepository jenisReksadanaRepository;

    @Autowired
    private JenisReksadanaMapper jenisReksadanaMapper;

    @Autowired
    private JenisReksadanaService jenisReksadanaService;

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

    private MockMvc restJenisReksadanaMockMvc;

    private JenisReksadana jenisReksadana;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final JenisReksadanaResource jenisReksadanaResource = new JenisReksadanaResource(jenisReksadanaService);
        this.restJenisReksadanaMockMvc = MockMvcBuilders.standaloneSetup(jenisReksadanaResource)
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
    public static JenisReksadana createEntity(EntityManager em) {
        JenisReksadana jenisReksadana = new JenisReksadana()
            .kodeJenis(DEFAULT_KODE_JENIS)
            .namaJenis(DEFAULT_NAMA_JENIS)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return jenisReksadana;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JenisReksadana createUpdatedEntity(EntityManager em) {
        JenisReksadana jenisReksadana = new JenisReksadana()
            .kodeJenis(UPDATED_KODE_JENIS)
            .namaJenis(UPDATED_NAMA_JENIS)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return jenisReksadana;
    }

    @BeforeEach
    public void initTest() {
        jenisReksadana = createEntity(em);
    }

    @Test
    @Transactional
    public void createJenisReksadana() throws Exception {
        int databaseSizeBeforeCreate = jenisReksadanaRepository.findAll().size();

        // Create the JenisReksadana
        JenisReksadanaDTO jenisReksadanaDTO = jenisReksadanaMapper.toDto(jenisReksadana);
        restJenisReksadanaMockMvc.perform(post("/api/jenis-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jenisReksadanaDTO)))
            .andExpect(status().isCreated());

        // Validate the JenisReksadana in the database
        List<JenisReksadana> jenisReksadanaList = jenisReksadanaRepository.findAll();
        assertThat(jenisReksadanaList).hasSize(databaseSizeBeforeCreate + 1);
        JenisReksadana testJenisReksadana = jenisReksadanaList.get(jenisReksadanaList.size() - 1);
        assertThat(testJenisReksadana.getKodeJenis()).isEqualTo(DEFAULT_KODE_JENIS);
        assertThat(testJenisReksadana.getNamaJenis()).isEqualTo(DEFAULT_NAMA_JENIS);
        assertThat(testJenisReksadana.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testJenisReksadana.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testJenisReksadana.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testJenisReksadana.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testJenisReksadana.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testJenisReksadana.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createJenisReksadanaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = jenisReksadanaRepository.findAll().size();

        // Create the JenisReksadana with an existing ID
        jenisReksadana.setId(1L);
        JenisReksadanaDTO jenisReksadanaDTO = jenisReksadanaMapper.toDto(jenisReksadana);

        // An entity with an existing ID cannot be created, so this API call must fail
        restJenisReksadanaMockMvc.perform(post("/api/jenis-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jenisReksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the JenisReksadana in the database
        List<JenisReksadana> jenisReksadanaList = jenisReksadanaRepository.findAll();
        assertThat(jenisReksadanaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllJenisReksadanas() throws Exception {
        // Initialize the database
        jenisReksadanaRepository.saveAndFlush(jenisReksadana);

        // Get all the jenisReksadanaList
        restJenisReksadanaMockMvc.perform(get("/api/jenis-reksadanas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(jenisReksadana.getId().intValue())))
            .andExpect(jsonPath("$.[*].kodeJenis").value(hasItem(DEFAULT_KODE_JENIS)))
            .andExpect(jsonPath("$.[*].namaJenis").value(hasItem(DEFAULT_NAMA_JENIS)))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getJenisReksadana() throws Exception {
        // Initialize the database
        jenisReksadanaRepository.saveAndFlush(jenisReksadana);

        // Get the jenisReksadana
        restJenisReksadanaMockMvc.perform(get("/api/jenis-reksadanas/{id}", jenisReksadana.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(jenisReksadana.getId().intValue()))
            .andExpect(jsonPath("$.kodeJenis").value(DEFAULT_KODE_JENIS))
            .andExpect(jsonPath("$.namaJenis").value(DEFAULT_NAMA_JENIS))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingJenisReksadana() throws Exception {
        // Get the jenisReksadana
        restJenisReksadanaMockMvc.perform(get("/api/jenis-reksadanas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateJenisReksadana() throws Exception {
        // Initialize the database
        jenisReksadanaRepository.saveAndFlush(jenisReksadana);

        int databaseSizeBeforeUpdate = jenisReksadanaRepository.findAll().size();

        // Update the jenisReksadana
        JenisReksadana updatedJenisReksadana = jenisReksadanaRepository.findById(jenisReksadana.getId()).get();
        // Disconnect from session so that the updates on updatedJenisReksadana are not directly saved in db
        em.detach(updatedJenisReksadana);
        updatedJenisReksadana
            .kodeJenis(UPDATED_KODE_JENIS)
            .namaJenis(UPDATED_NAMA_JENIS)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        JenisReksadanaDTO jenisReksadanaDTO = jenisReksadanaMapper.toDto(updatedJenisReksadana);

        restJenisReksadanaMockMvc.perform(put("/api/jenis-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jenisReksadanaDTO)))
            .andExpect(status().isOk());

        // Validate the JenisReksadana in the database
        List<JenisReksadana> jenisReksadanaList = jenisReksadanaRepository.findAll();
        assertThat(jenisReksadanaList).hasSize(databaseSizeBeforeUpdate);
        JenisReksadana testJenisReksadana = jenisReksadanaList.get(jenisReksadanaList.size() - 1);
        assertThat(testJenisReksadana.getKodeJenis()).isEqualTo(UPDATED_KODE_JENIS);
        assertThat(testJenisReksadana.getNamaJenis()).isEqualTo(UPDATED_NAMA_JENIS);
        assertThat(testJenisReksadana.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testJenisReksadana.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testJenisReksadana.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testJenisReksadana.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testJenisReksadana.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testJenisReksadana.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingJenisReksadana() throws Exception {
        int databaseSizeBeforeUpdate = jenisReksadanaRepository.findAll().size();

        // Create the JenisReksadana
        JenisReksadanaDTO jenisReksadanaDTO = jenisReksadanaMapper.toDto(jenisReksadana);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJenisReksadanaMockMvc.perform(put("/api/jenis-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jenisReksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the JenisReksadana in the database
        List<JenisReksadana> jenisReksadanaList = jenisReksadanaRepository.findAll();
        assertThat(jenisReksadanaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteJenisReksadana() throws Exception {
        // Initialize the database
        jenisReksadanaRepository.saveAndFlush(jenisReksadana);

        int databaseSizeBeforeDelete = jenisReksadanaRepository.findAll().size();

        // Delete the jenisReksadana
        restJenisReksadanaMockMvc.perform(delete("/api/jenis-reksadanas/{id}", jenisReksadana.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<JenisReksadana> jenisReksadanaList = jenisReksadanaRepository.findAll();
        assertThat(jenisReksadanaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
