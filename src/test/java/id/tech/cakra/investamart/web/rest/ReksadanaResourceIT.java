package id.tech.cakra.investamart.web.rest;

import id.tech.cakra.investamart.InvestacoresvcApp;
import id.tech.cakra.investamart.domain.Reksadana;
import id.tech.cakra.investamart.repository.ReksadanaRepository;
import id.tech.cakra.investamart.service.ReksadanaService;
import id.tech.cakra.investamart.service.dto.ReksadanaDTO;
import id.tech.cakra.investamart.service.mapper.ReksadanaMapper;
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
 * Integration tests for the {@link ReksadanaResource} REST controller.
 */
@SpringBootTest(classes = InvestacoresvcApp.class)
public class ReksadanaResourceIT {

    private static final String DEFAULT_KODE_REKSADANA = "AAAAAAAAAA";
    private static final String UPDATED_KODE_REKSADANA = "BBBBBBBBBB";

    private static final String DEFAULT_NAMA_REKSADANA = "AAAAAAAAAA";
    private static final String UPDATED_NAMA_REKSADANA = "BBBBBBBBBB";

    private static final String DEFAULT_ISIN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ISIN_CODE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_TANGGAL_PELUNCURAN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TANGGAL_PELUNCURAN = LocalDate.now(ZoneId.systemDefault());

    private static final BigDecimal DEFAULT_AUM = new BigDecimal(1);
    private static final BigDecimal UPDATED_AUM = new BigDecimal(2);

    private static final BigDecimal DEFAULT_UNIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_UNIT = new BigDecimal(2);

    private static final LocalDate DEFAULT_LAST_POS_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_LAST_POS_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final BigDecimal DEFAULT_BIAYA_PEMBELIAN = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIAYA_PEMBELIAN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIAYA_PENJUALAN = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIAYA_PENJUALAN = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BIAYA_SWITCHING = new BigDecimal(1);
    private static final BigDecimal UPDATED_BIAYA_SWITCHING = new BigDecimal(2);

    private static final String DEFAULT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "A";
    private static final String UPDATED_STATUS = "B";

    private static final BigDecimal DEFAULT_NAV = new BigDecimal(1);
    private static final BigDecimal UPDATED_NAV = new BigDecimal(2);

    private static final Double DEFAULT_BAROMETER = 1D;
    private static final Double UPDATED_BAROMETER = 2D;

    private static final Long DEFAULT_CURRENCY_ID = 1L;
    private static final Long UPDATED_CURRENCY_ID = 2L;

    private static final Long DEFAULT_ISSUER_ID = 1L;
    private static final Long UPDATED_ISSUER_ID = 2L;

    private static final Long DEFAULT_CUSTODY_ID = 1L;
    private static final Long UPDATED_CUSTODY_ID = 2L;

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
    private ReksadanaRepository reksadanaRepository;

    @Autowired
    private ReksadanaMapper reksadanaMapper;

    @Autowired
    private ReksadanaService reksadanaService;

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

    private MockMvc restReksadanaMockMvc;

    private Reksadana reksadana;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ReksadanaResource reksadanaResource = new ReksadanaResource(reksadanaService);
        this.restReksadanaMockMvc = MockMvcBuilders.standaloneSetup(reksadanaResource)
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
    public static Reksadana createEntity(EntityManager em) {
        Reksadana reksadana = new Reksadana()
            .kodeReksadana(DEFAULT_KODE_REKSADANA)
            .namaReksadana(DEFAULT_NAMA_REKSADANA)
            .isinCode(DEFAULT_ISIN_CODE)
            .tanggalPeluncuran(DEFAULT_TANGGAL_PELUNCURAN)
            .aum(DEFAULT_AUM)
            .unit(DEFAULT_UNIT)
            .lastPosDate(DEFAULT_LAST_POS_DATE)
            .biayaPembelian(DEFAULT_BIAYA_PEMBELIAN)
            .biayaPenjualan(DEFAULT_BIAYA_PENJUALAN)
            .biayaSwitching(DEFAULT_BIAYA_SWITCHING)
            .notes(DEFAULT_NOTES)
            .status(DEFAULT_STATUS)
            .nav(DEFAULT_NAV)
            .barometer(DEFAULT_BAROMETER)
            .currencyId(DEFAULT_CURRENCY_ID)
            .issuerId(DEFAULT_ISSUER_ID)
            .custodyId(DEFAULT_CUSTODY_ID)
            .createSystemDate(DEFAULT_CREATE_SYSTEM_DATE)
            .createDate(DEFAULT_CREATE_DATE)
            .createUserId(DEFAULT_CREATE_USER_ID)
            .lastModificationSystemDate(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(DEFAULT_LAST_MODIFICATION_DATE)
            .lastModificationUserId(DEFAULT_LAST_MODIFICATION_USER_ID);
        return reksadana;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Reksadana createUpdatedEntity(EntityManager em) {
        Reksadana reksadana = new Reksadana()
            .kodeReksadana(UPDATED_KODE_REKSADANA)
            .namaReksadana(UPDATED_NAMA_REKSADANA)
            .isinCode(UPDATED_ISIN_CODE)
            .tanggalPeluncuran(UPDATED_TANGGAL_PELUNCURAN)
            .aum(UPDATED_AUM)
            .unit(UPDATED_UNIT)
            .lastPosDate(UPDATED_LAST_POS_DATE)
            .biayaPembelian(UPDATED_BIAYA_PEMBELIAN)
            .biayaPenjualan(UPDATED_BIAYA_PENJUALAN)
            .biayaSwitching(UPDATED_BIAYA_SWITCHING)
            .notes(UPDATED_NOTES)
            .status(UPDATED_STATUS)
            .nav(UPDATED_NAV)
            .barometer(UPDATED_BAROMETER)
            .currencyId(UPDATED_CURRENCY_ID)
            .issuerId(UPDATED_ISSUER_ID)
            .custodyId(UPDATED_CUSTODY_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        return reksadana;
    }

    @BeforeEach
    public void initTest() {
        reksadana = createEntity(em);
    }

    @Test
    @Transactional
    public void createReksadana() throws Exception {
        int databaseSizeBeforeCreate = reksadanaRepository.findAll().size();

        // Create the Reksadana
        ReksadanaDTO reksadanaDTO = reksadanaMapper.toDto(reksadana);
        restReksadanaMockMvc.perform(post("/api/reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaDTO)))
            .andExpect(status().isCreated());

        // Validate the Reksadana in the database
        List<Reksadana> reksadanaList = reksadanaRepository.findAll();
        assertThat(reksadanaList).hasSize(databaseSizeBeforeCreate + 1);
        Reksadana testReksadana = reksadanaList.get(reksadanaList.size() - 1);
        assertThat(testReksadana.getKodeReksadana()).isEqualTo(DEFAULT_KODE_REKSADANA);
        assertThat(testReksadana.getNamaReksadana()).isEqualTo(DEFAULT_NAMA_REKSADANA);
        assertThat(testReksadana.getIsinCode()).isEqualTo(DEFAULT_ISIN_CODE);
        assertThat(testReksadana.getTanggalPeluncuran()).isEqualTo(DEFAULT_TANGGAL_PELUNCURAN);
        assertThat(testReksadana.getAum()).isEqualTo(DEFAULT_AUM);
        assertThat(testReksadana.getUnit()).isEqualTo(DEFAULT_UNIT);
        assertThat(testReksadana.getLastPosDate()).isEqualTo(DEFAULT_LAST_POS_DATE);
        assertThat(testReksadana.getBiayaPembelian()).isEqualTo(DEFAULT_BIAYA_PEMBELIAN);
        assertThat(testReksadana.getBiayaPenjualan()).isEqualTo(DEFAULT_BIAYA_PENJUALAN);
        assertThat(testReksadana.getBiayaSwitching()).isEqualTo(DEFAULT_BIAYA_SWITCHING);
        assertThat(testReksadana.getNotes()).isEqualTo(DEFAULT_NOTES);
        assertThat(testReksadana.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testReksadana.getNav()).isEqualTo(DEFAULT_NAV);
        assertThat(testReksadana.getBarometer()).isEqualTo(DEFAULT_BAROMETER);
        assertThat(testReksadana.getCurrencyId()).isEqualTo(DEFAULT_CURRENCY_ID);
        assertThat(testReksadana.getIssuerId()).isEqualTo(DEFAULT_ISSUER_ID);
        assertThat(testReksadana.getCustodyId()).isEqualTo(DEFAULT_CUSTODY_ID);
        assertThat(testReksadana.getCreateSystemDate()).isEqualTo(DEFAULT_CREATE_SYSTEM_DATE);
        assertThat(testReksadana.getCreateDate()).isEqualTo(DEFAULT_CREATE_DATE);
        assertThat(testReksadana.getCreateUserId()).isEqualTo(DEFAULT_CREATE_USER_ID);
        assertThat(testReksadana.getLastModificationSystemDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadana.getLastModificationDate()).isEqualTo(DEFAULT_LAST_MODIFICATION_DATE);
        assertThat(testReksadana.getLastModificationUserId()).isEqualTo(DEFAULT_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void createReksadanaWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = reksadanaRepository.findAll().size();

        // Create the Reksadana with an existing ID
        reksadana.setId(1L);
        ReksadanaDTO reksadanaDTO = reksadanaMapper.toDto(reksadana);

        // An entity with an existing ID cannot be created, so this API call must fail
        restReksadanaMockMvc.perform(post("/api/reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reksadana in the database
        List<Reksadana> reksadanaList = reksadanaRepository.findAll();
        assertThat(reksadanaList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllReksadanas() throws Exception {
        // Initialize the database
        reksadanaRepository.saveAndFlush(reksadana);

        // Get all the reksadanaList
        restReksadanaMockMvc.perform(get("/api/reksadanas?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(reksadana.getId().intValue())))
            .andExpect(jsonPath("$.[*].kodeReksadana").value(hasItem(DEFAULT_KODE_REKSADANA)))
            .andExpect(jsonPath("$.[*].namaReksadana").value(hasItem(DEFAULT_NAMA_REKSADANA)))
            .andExpect(jsonPath("$.[*].isinCode").value(hasItem(DEFAULT_ISIN_CODE)))
            .andExpect(jsonPath("$.[*].tanggalPeluncuran").value(hasItem(DEFAULT_TANGGAL_PELUNCURAN.toString())))
            .andExpect(jsonPath("$.[*].aum").value(hasItem(DEFAULT_AUM.intValue())))
            .andExpect(jsonPath("$.[*].unit").value(hasItem(DEFAULT_UNIT.intValue())))
            .andExpect(jsonPath("$.[*].lastPosDate").value(hasItem(DEFAULT_LAST_POS_DATE.toString())))
            .andExpect(jsonPath("$.[*].biayaPembelian").value(hasItem(DEFAULT_BIAYA_PEMBELIAN.intValue())))
            .andExpect(jsonPath("$.[*].biayaPenjualan").value(hasItem(DEFAULT_BIAYA_PENJUALAN.intValue())))
            .andExpect(jsonPath("$.[*].biayaSwitching").value(hasItem(DEFAULT_BIAYA_SWITCHING.intValue())))
            .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].nav").value(hasItem(DEFAULT_NAV.intValue())))
            .andExpect(jsonPath("$.[*].barometer").value(hasItem(DEFAULT_BAROMETER.doubleValue())))
            .andExpect(jsonPath("$.[*].currencyId").value(hasItem(DEFAULT_CURRENCY_ID.intValue())))
            .andExpect(jsonPath("$.[*].issuerId").value(hasItem(DEFAULT_ISSUER_ID.intValue())))
            .andExpect(jsonPath("$.[*].custodyId").value(hasItem(DEFAULT_CUSTODY_ID.intValue())))
            .andExpect(jsonPath("$.[*].createSystemDate").value(hasItem(DEFAULT_CREATE_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].createDate").value(hasItem(sameInstant(DEFAULT_CREATE_DATE))))
            .andExpect(jsonPath("$.[*].createUserId").value(hasItem(DEFAULT_CREATE_USER_ID.intValue())))
            .andExpect(jsonPath("$.[*].lastModificationSystemDate").value(hasItem(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastModificationDate").value(hasItem(sameInstant(DEFAULT_LAST_MODIFICATION_DATE))))
            .andExpect(jsonPath("$.[*].lastModificationUserId").value(hasItem(DEFAULT_LAST_MODIFICATION_USER_ID.intValue())));
    }
    
    @Test
    @Transactional
    public void getReksadana() throws Exception {
        // Initialize the database
        reksadanaRepository.saveAndFlush(reksadana);

        // Get the reksadana
        restReksadanaMockMvc.perform(get("/api/reksadanas/{id}", reksadana.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(reksadana.getId().intValue()))
            .andExpect(jsonPath("$.kodeReksadana").value(DEFAULT_KODE_REKSADANA))
            .andExpect(jsonPath("$.namaReksadana").value(DEFAULT_NAMA_REKSADANA))
            .andExpect(jsonPath("$.isinCode").value(DEFAULT_ISIN_CODE))
            .andExpect(jsonPath("$.tanggalPeluncuran").value(DEFAULT_TANGGAL_PELUNCURAN.toString()))
            .andExpect(jsonPath("$.aum").value(DEFAULT_AUM.intValue()))
            .andExpect(jsonPath("$.unit").value(DEFAULT_UNIT.intValue()))
            .andExpect(jsonPath("$.lastPosDate").value(DEFAULT_LAST_POS_DATE.toString()))
            .andExpect(jsonPath("$.biayaPembelian").value(DEFAULT_BIAYA_PEMBELIAN.intValue()))
            .andExpect(jsonPath("$.biayaPenjualan").value(DEFAULT_BIAYA_PENJUALAN.intValue()))
            .andExpect(jsonPath("$.biayaSwitching").value(DEFAULT_BIAYA_SWITCHING.intValue()))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.nav").value(DEFAULT_NAV.intValue()))
            .andExpect(jsonPath("$.barometer").value(DEFAULT_BAROMETER.doubleValue()))
            .andExpect(jsonPath("$.currencyId").value(DEFAULT_CURRENCY_ID.intValue()))
            .andExpect(jsonPath("$.issuerId").value(DEFAULT_ISSUER_ID.intValue()))
            .andExpect(jsonPath("$.custodyId").value(DEFAULT_CUSTODY_ID.intValue()))
            .andExpect(jsonPath("$.createSystemDate").value(DEFAULT_CREATE_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.createDate").value(sameInstant(DEFAULT_CREATE_DATE)))
            .andExpect(jsonPath("$.createUserId").value(DEFAULT_CREATE_USER_ID.intValue()))
            .andExpect(jsonPath("$.lastModificationSystemDate").value(DEFAULT_LAST_MODIFICATION_SYSTEM_DATE.toString()))
            .andExpect(jsonPath("$.lastModificationDate").value(sameInstant(DEFAULT_LAST_MODIFICATION_DATE)))
            .andExpect(jsonPath("$.lastModificationUserId").value(DEFAULT_LAST_MODIFICATION_USER_ID.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingReksadana() throws Exception {
        // Get the reksadana
        restReksadanaMockMvc.perform(get("/api/reksadanas/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateReksadana() throws Exception {
        // Initialize the database
        reksadanaRepository.saveAndFlush(reksadana);

        int databaseSizeBeforeUpdate = reksadanaRepository.findAll().size();

        // Update the reksadana
        Reksadana updatedReksadana = reksadanaRepository.findById(reksadana.getId()).get();
        // Disconnect from session so that the updates on updatedReksadana are not directly saved in db
        em.detach(updatedReksadana);
        updatedReksadana
            .kodeReksadana(UPDATED_KODE_REKSADANA)
            .namaReksadana(UPDATED_NAMA_REKSADANA)
            .isinCode(UPDATED_ISIN_CODE)
            .tanggalPeluncuran(UPDATED_TANGGAL_PELUNCURAN)
            .aum(UPDATED_AUM)
            .unit(UPDATED_UNIT)
            .lastPosDate(UPDATED_LAST_POS_DATE)
            .biayaPembelian(UPDATED_BIAYA_PEMBELIAN)
            .biayaPenjualan(UPDATED_BIAYA_PENJUALAN)
            .biayaSwitching(UPDATED_BIAYA_SWITCHING)
            .notes(UPDATED_NOTES)
            .status(UPDATED_STATUS)
            .nav(UPDATED_NAV)
            .barometer(UPDATED_BAROMETER)
            .currencyId(UPDATED_CURRENCY_ID)
            .issuerId(UPDATED_ISSUER_ID)
            .custodyId(UPDATED_CUSTODY_ID)
            .createSystemDate(UPDATED_CREATE_SYSTEM_DATE)
            .createDate(UPDATED_CREATE_DATE)
            .createUserId(UPDATED_CREATE_USER_ID)
            .lastModificationSystemDate(UPDATED_LAST_MODIFICATION_SYSTEM_DATE)
            .lastModificationDate(UPDATED_LAST_MODIFICATION_DATE)
            .lastModificationUserId(UPDATED_LAST_MODIFICATION_USER_ID);
        ReksadanaDTO reksadanaDTO = reksadanaMapper.toDto(updatedReksadana);

        restReksadanaMockMvc.perform(put("/api/reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaDTO)))
            .andExpect(status().isOk());

        // Validate the Reksadana in the database
        List<Reksadana> reksadanaList = reksadanaRepository.findAll();
        assertThat(reksadanaList).hasSize(databaseSizeBeforeUpdate);
        Reksadana testReksadana = reksadanaList.get(reksadanaList.size() - 1);
        assertThat(testReksadana.getKodeReksadana()).isEqualTo(UPDATED_KODE_REKSADANA);
        assertThat(testReksadana.getNamaReksadana()).isEqualTo(UPDATED_NAMA_REKSADANA);
        assertThat(testReksadana.getIsinCode()).isEqualTo(UPDATED_ISIN_CODE);
        assertThat(testReksadana.getTanggalPeluncuran()).isEqualTo(UPDATED_TANGGAL_PELUNCURAN);
        assertThat(testReksadana.getAum()).isEqualTo(UPDATED_AUM);
        assertThat(testReksadana.getUnit()).isEqualTo(UPDATED_UNIT);
        assertThat(testReksadana.getLastPosDate()).isEqualTo(UPDATED_LAST_POS_DATE);
        assertThat(testReksadana.getBiayaPembelian()).isEqualTo(UPDATED_BIAYA_PEMBELIAN);
        assertThat(testReksadana.getBiayaPenjualan()).isEqualTo(UPDATED_BIAYA_PENJUALAN);
        assertThat(testReksadana.getBiayaSwitching()).isEqualTo(UPDATED_BIAYA_SWITCHING);
        assertThat(testReksadana.getNotes()).isEqualTo(UPDATED_NOTES);
        assertThat(testReksadana.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testReksadana.getNav()).isEqualTo(UPDATED_NAV);
        assertThat(testReksadana.getBarometer()).isEqualTo(UPDATED_BAROMETER);
        assertThat(testReksadana.getCurrencyId()).isEqualTo(UPDATED_CURRENCY_ID);
        assertThat(testReksadana.getIssuerId()).isEqualTo(UPDATED_ISSUER_ID);
        assertThat(testReksadana.getCustodyId()).isEqualTo(UPDATED_CUSTODY_ID);
        assertThat(testReksadana.getCreateSystemDate()).isEqualTo(UPDATED_CREATE_SYSTEM_DATE);
        assertThat(testReksadana.getCreateDate()).isEqualTo(UPDATED_CREATE_DATE);
        assertThat(testReksadana.getCreateUserId()).isEqualTo(UPDATED_CREATE_USER_ID);
        assertThat(testReksadana.getLastModificationSystemDate()).isEqualTo(UPDATED_LAST_MODIFICATION_SYSTEM_DATE);
        assertThat(testReksadana.getLastModificationDate()).isEqualTo(UPDATED_LAST_MODIFICATION_DATE);
        assertThat(testReksadana.getLastModificationUserId()).isEqualTo(UPDATED_LAST_MODIFICATION_USER_ID);
    }

    @Test
    @Transactional
    public void updateNonExistingReksadana() throws Exception {
        int databaseSizeBeforeUpdate = reksadanaRepository.findAll().size();

        // Create the Reksadana
        ReksadanaDTO reksadanaDTO = reksadanaMapper.toDto(reksadana);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restReksadanaMockMvc.perform(put("/api/reksadanas")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(reksadanaDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Reksadana in the database
        List<Reksadana> reksadanaList = reksadanaRepository.findAll();
        assertThat(reksadanaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteReksadana() throws Exception {
        // Initialize the database
        reksadanaRepository.saveAndFlush(reksadana);

        int databaseSizeBeforeDelete = reksadanaRepository.findAll().size();

        // Delete the reksadana
        restReksadanaMockMvc.perform(delete("/api/reksadanas/{id}", reksadana.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Reksadana> reksadanaList = reksadanaRepository.findAll();
        assertThat(reksadanaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
