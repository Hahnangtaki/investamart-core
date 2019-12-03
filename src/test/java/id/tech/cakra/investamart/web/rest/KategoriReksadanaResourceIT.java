package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.KategoriReksadana;
import id.tech.cakra.investamart.repository.KategoriReksadanaRepository;
import id.tech.cakra.investamart.service.KategoriReksadanaService;
import id.tech.cakra.investamart.service.dto.KategoriReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.KategoriReksadanaMapper;
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
 * Integration tests for the {@link KategoriReksadanaResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class KategoriReksadanaResourceIT {

    private static final String DEFAULT_KODE_KATEGORI = "AAAAAAAAAA";
    private static final String UPDATED_KODE_KATEGORI = "BBBBBBBBBB";

    private static final String DEFAULT_NAMA_KATEGORI = "AAAAAAAAAA";
    private static final String UPDATED_NAMA_KATEGORI = "BBBBBBBBBB";

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
    private KategoriReksadanaRepository kategoriReksadanaRepository;

    @Autowired
    private KategoriReksadanaMapper kategoriReksadanaMapper;

    @Autowired
    private KategoriReksadanaService kategoriReksadanaService;

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

    private MockMvc restKategoriReksadanaMockMvc;

    private KategoriReksadana kategoriReksadana;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final KategoriReksadanaResource kategoriReksadanaResource = new KategoriReksadanaResource(kategoriReksadanaService);
        this.restKategoriReksadanaMockMvc = MockMvcBuilders.standaloneSetup(kategoriReksadanaResource)
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
    public static KategoriReksadana createEntity(EntityManager em) {
        KategoriReksadana kategoriReksadana = new KategoriReksadana()
            .kodeKategori(DEFAULT_KODE_KATEGORI)
            .namaKategori(DEFAULT_NAMA_KATEGORI)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return kategoriReksadana;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static KategoriReksadana createUpdatedEntity(EntityManager em) {
        KategoriReksadana kategoriReksadana = new KategoriReksadana()
            .kodeKategori(UPDATED_KODE_KATEGORI)
            .namaKategori(UPDATED_NAMA_KATEGORI)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return kategoriReksadana;
    }

    @BeforeEach
    public void initTest() {
        kategoriReksadana = createEntity(em);
    }

    @Test
    @Transactional
    public void createKategoriReksadana() throws Exception {
        int databaseSizeBeforeCreate = kategoriReksadanaRepository.findAll().size();

        // Create the KategoriReksadana
        KategoriReksadanaDTO kategoriReksadanaDTO = kategoriReksadanaMapper.toDto(kategoriReksadana);
        restKategoriReksadanaMockMvc.perform(post("/api/kategori-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kategoriReksadanaDTO)))
            .andExpect(status().isCreated());

        // Validate the KategoriReksadana in the database
        List<KategoriReksadana> kategoriReksadanaList = kategoriReksadanaRepository.findAll();
        assertThat(kategoriReksadanaList).hasSize(databaseSizeBeforeCreate + 1);
        KategoriReksadana testKategoriReksadana = kategoriReksadanaList.get(kategoriReksadanaList.size() - 1);
        assertThat(testKategoriReksadana.getKodeKategori()).isEqualTo(DEFAULT_KODE_KATEGORI);
        assertThat(testKategoriReksadana.getNamaKategori()).isEqualTo(DEFAULT_NAMA_KATEGORI);
        assertThat(testKategoriReksadana.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testKategoriReksadana.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testKategoriReksadana.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testKategoriReksadana.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testKategoriReksadana.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testKategoriReksadana.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createKategoriReksadanaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = kategoriReksadanaRepository.findAll().size();

        // Create the KategoriReksadana with an existing ID
        kategoriReksadana.setId(1L);
        KategoriReksadanaDTO kategoriReksadanaDTO = kategoriReksadanaMapper.toDto(kategoriReksadana);

        // An entity with an existing ID cannot be created, so this API call must fail
        restKategoriReksadanaMockMvc.perform(post("/api/kategori-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kategoriReksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the KategoriReksadana in the database
        List<KategoriReksadana> kategoriReksadanaList = kategoriReksadanaRepository.findAll();
        assertThat(kategoriReksadanaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllKategoriReksadanas() throws Exception {
        // Initialize the database
        kategoriReksadanaRepository.saveAndFlush(kategoriReksadana);

        // Get all the kategoriReksadanaList
        restKategoriReksadanaMockMvc.perform(get("/api/kategori-reksadanas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(kategoriReksadana.getId().intValue())))
            .andExpect(jsonPath("$.[*].kodeKategori").value(hasItem(DEFAULT_KODE_KATEGORI)))
            .andExpect(jsonPath("$.[*].namaKategori").value(hasItem(DEFAULT_NAMA_KATEGORI)))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getKategoriReksadana() throws Exception {
        // Initialize the database
        kategoriReksadanaRepository.saveAndFlush(kategoriReksadana);

        // Get the kategoriReksadana
        restKategoriReksadanaMockMvc.perform(get("/api/kategori-reksadanas/{id}", kategoriReksadana.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(kategoriReksadana.getId().intValue()))
            .andExpect(jsonPath("$.kodeKategori").value(DEFAULT_KODE_KATEGORI))
            .andExpect(jsonPath("$.namaKategori").value(DEFAULT_NAMA_KATEGORI))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingKategoriReksadana() throws Exception {
        // Get the kategoriReksadana
        restKategoriReksadanaMockMvc.perform(get("/api/kategori-reksadanas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateKategoriReksadana() throws Exception {
        // Initialize the database
        kategoriReksadanaRepository.saveAndFlush(kategoriReksadana);

        int databaseSizeBeforeUpdate = kategoriReksadanaRepository.findAll().size();

        // Update the kategoriReksadana
        KategoriReksadana updatedKategoriReksadana = kategoriReksadanaRepository.findById(kategoriReksadana.getId()).get();
        // Disconnect from session so that the updates on updatedKategoriReksadana are not directly saved in db
        em.detach(updatedKategoriReksadana);
        updatedKategoriReksadana
            .kodeKategori(UPDATED_KODE_KATEGORI)
            .namaKategori(UPDATED_NAMA_KATEGORI)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        KategoriReksadanaDTO kategoriReksadanaDTO = kategoriReksadanaMapper.toDto(updatedKategoriReksadana);

        restKategoriReksadanaMockMvc.perform(put("/api/kategori-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kategoriReksadanaDTO)))
            .andExpect(status().isOk());

        // Validate the KategoriReksadana in the database
        List<KategoriReksadana> kategoriReksadanaList = kategoriReksadanaRepository.findAll();
        assertThat(kategoriReksadanaList).hasSize(databaseSizeBeforeUpdate);
        KategoriReksadana testKategoriReksadana = kategoriReksadanaList.get(kategoriReksadanaList.size() - 1);
        assertThat(testKategoriReksadana.getKodeKategori()).isEqualTo(UPDATED_KODE_KATEGORI);
        assertThat(testKategoriReksadana.getNamaKategori()).isEqualTo(UPDATED_NAMA_KATEGORI);
        assertThat(testKategoriReksadana.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testKategoriReksadana.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testKategoriReksadana.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testKategoriReksadana.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testKategoriReksadana.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testKategoriReksadana.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingKategoriReksadana() throws Exception {
        int databaseSizeBeforeUpdate = kategoriReksadanaRepository.findAll().size();

        // Create the KategoriReksadana
        KategoriReksadanaDTO kategoriReksadanaDTO = kategoriReksadanaMapper.toDto(kategoriReksadana);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restKategoriReksadanaMockMvc.perform(put("/api/kategori-reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(kategoriReksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the KategoriReksadana in the database
        List<KategoriReksadana> kategoriReksadanaList = kategoriReksadanaRepository.findAll();
        assertThat(kategoriReksadanaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteKategoriReksadana() throws Exception {
        // Initialize the database
        kategoriReksadanaRepository.saveAndFlush(kategoriReksadana);

        int databaseSizeBeforeDelete = kategoriReksadanaRepository.findAll().size();

        // Delete the kategoriReksadana
        restKategoriReksadanaMockMvc.perform(delete("/api/kategori-reksadanas/{id}", kategoriReksadana.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<KategoriReksadana> kategoriReksadanaList = kategoriReksadanaRepository.findAll();
        assertThat(kategoriReksadanaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
