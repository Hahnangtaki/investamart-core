package id.tech.cakra.investamart.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Reksadana.
 */
@Entity
@Table(name = "reksadana")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reksadana implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 20)
    @Column(name = "kode_reksadana", length = 20)
    private String kodeReksadana;

    @Size(max = 100)
    @Column(name = "nama_reksadana", length = 100)
    private String namaReksadana;

    @Size(max = 20)
    @Column(name = "isin_code", length = 20)
    private String isinCode;

    @Column(name = "tanggal_peluncuran")
    private LocalDate tanggalPeluncuran;

    @Column(name = "aum", precision = 21, scale = 2)
    private BigDecimal aum;

    @Column(name = "unit", precision = 21, scale = 2)
    private BigDecimal unit;

    @Column(name = "last_pos_date")
    private LocalDate lastPosDate;

    @Column(name = "biaya_pembelian", precision = 21, scale = 2)
    private BigDecimal biayaPembelian;

    @Column(name = "biaya_penjualan", precision = 21, scale = 2)
    private BigDecimal biayaPenjualan;

    @Column(name = "biaya_switching", precision = 21, scale = 2)
    private BigDecimal biayaSwitching;

    @Column(name = "notes")
    private String notes;

    @Size(max = 1)
    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "nav", precision = 21, scale = 2)
    private BigDecimal nav;

    @Column(name = "barometer")
    private Double barometer;

    @Column(name = "currency_id")
    private Long currencyId;

    @Column(name = "issuer_id")
    private Long issuerId;

    @Column(name = "custody_id")
    private Long custodyId;

    @Column(name = "create_system_date")
    private LocalDate createSystemDate;

    @Column(name = "create_date")
    private ZonedDateTime createDate;

    @Column(name = "create_user_id")
    private Long createUserId;

    @Column(name = "last_modification_system_date")
    private LocalDate lastModificationSystemDate;

    @Column(name = "last_modification_date")
    private ZonedDateTime lastModificationDate;

    @Column(name = "last_modification_user_id")
    private Long lastModificationUserId;

    @OneToMany(mappedBy = "reksadana")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReksadanaAssetAllocation> reksadanaAssetAllocations = new HashSet<>();

    @OneToMany(mappedBy = "reksadana")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReksadanaTransaction> reksadanaTransactions = new HashSet<>();

    @OneToMany(mappedBy = "reksadana")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReksadanaAsset> reksadanaAssets = new HashSet<>();

    @OneToMany(mappedBy = "reksaSource")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReksadanaSwitching> sourceReks = new HashSet<>();

    @OneToMany(mappedBy = "reksaTarget")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReksadanaSwitching> targetReks = new HashSet<>();

    @OneToMany(mappedBy = "reksadana")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountReksadana> accountReksadanas = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("reksadanas")
    private JenisReksadana jenisReksadana;

    @ManyToOne
    @JsonIgnoreProperties("reksadanas")
    private KategoriReksadana kategoriReksadana;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeReksadana() {
        return kodeReksadana;
    }

    public Reksadana kodeReksadana(String kodeReksadana) {
        this.kodeReksadana = kodeReksadana;
        return this;
    }

    public void setKodeReksadana(String kodeReksadana) {
        this.kodeReksadana = kodeReksadana;
    }

    public String getNamaReksadana() {
        return namaReksadana;
    }

    public Reksadana namaReksadana(String namaReksadana) {
        this.namaReksadana = namaReksadana;
        return this;
    }

    public void setNamaReksadana(String namaReksadana) {
        this.namaReksadana = namaReksadana;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public Reksadana isinCode(String isinCode) {
        this.isinCode = isinCode;
        return this;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public LocalDate getTanggalPeluncuran() {
        return tanggalPeluncuran;
    }

    public Reksadana tanggalPeluncuran(LocalDate tanggalPeluncuran) {
        this.tanggalPeluncuran = tanggalPeluncuran;
        return this;
    }

    public void setTanggalPeluncuran(LocalDate tanggalPeluncuran) {
        this.tanggalPeluncuran = tanggalPeluncuran;
    }

    public BigDecimal getAum() {
        return aum;
    }

    public Reksadana aum(BigDecimal aum) {
        this.aum = aum;
        return this;
    }

    public void setAum(BigDecimal aum) {
        this.aum = aum;
    }

    public BigDecimal getUnit() {
        return unit;
    }

    public Reksadana unit(BigDecimal unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(BigDecimal unit) {
        this.unit = unit;
    }

    public LocalDate getLastPosDate() {
        return lastPosDate;
    }

    public Reksadana lastPosDate(LocalDate lastPosDate) {
        this.lastPosDate = lastPosDate;
        return this;
    }

    public void setLastPosDate(LocalDate lastPosDate) {
        this.lastPosDate = lastPosDate;
    }

    public BigDecimal getBiayaPembelian() {
        return biayaPembelian;
    }

    public Reksadana biayaPembelian(BigDecimal biayaPembelian) {
        this.biayaPembelian = biayaPembelian;
        return this;
    }

    public void setBiayaPembelian(BigDecimal biayaPembelian) {
        this.biayaPembelian = biayaPembelian;
    }

    public BigDecimal getBiayaPenjualan() {
        return biayaPenjualan;
    }

    public Reksadana biayaPenjualan(BigDecimal biayaPenjualan) {
        this.biayaPenjualan = biayaPenjualan;
        return this;
    }

    public void setBiayaPenjualan(BigDecimal biayaPenjualan) {
        this.biayaPenjualan = biayaPenjualan;
    }

    public BigDecimal getBiayaSwitching() {
        return biayaSwitching;
    }

    public Reksadana biayaSwitching(BigDecimal biayaSwitching) {
        this.biayaSwitching = biayaSwitching;
        return this;
    }

    public void setBiayaSwitching(BigDecimal biayaSwitching) {
        this.biayaSwitching = biayaSwitching;
    }

    public String getNotes() {
        return notes;
    }

    public Reksadana notes(String notes) {
        this.notes = notes;
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public Reksadana status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getNav() {
        return nav;
    }

    public Reksadana nav(BigDecimal nav) {
        this.nav = nav;
        return this;
    }

    public void setNav(BigDecimal nav) {
        this.nav = nav;
    }

    public Double getBarometer() {
        return barometer;
    }

    public Reksadana barometer(Double barometer) {
        this.barometer = barometer;
        return this;
    }

    public void setBarometer(Double barometer) {
        this.barometer = barometer;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public Reksadana currencyId(Long currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getIssuerId() {
        return issuerId;
    }

    public Reksadana issuerId(Long issuerId) {
        this.issuerId = issuerId;
        return this;
    }

    public void setIssuerId(Long issuerId) {
        this.issuerId = issuerId;
    }

    public Long getCustodyId() {
        return custodyId;
    }

    public Reksadana custodyId(Long custodyId) {
        this.custodyId = custodyId;
        return this;
    }

    public void setCustodyId(Long custodyId) {
        this.custodyId = custodyId;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public Reksadana createSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
        return this;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public Reksadana createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public Reksadana createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public Reksadana lastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
        return this;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public Reksadana lastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public Reksadana lastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
        return this;
    }

    public void setLastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public Set<ReksadanaAssetAllocation> getReksadanaAssetAllocations() {
        return reksadanaAssetAllocations;
    }

    public Reksadana reksadanaAssetAllocations(Set<ReksadanaAssetAllocation> reksadanaAssetAllocations) {
        this.reksadanaAssetAllocations = reksadanaAssetAllocations;
        return this;
    }

    public Reksadana addReksadanaAssetAllocation(ReksadanaAssetAllocation reksadanaAssetAllocation) {
        this.reksadanaAssetAllocations.add(reksadanaAssetAllocation);
        reksadanaAssetAllocation.setReksadana(this);
        return this;
    }

    public Reksadana removeReksadanaAssetAllocation(ReksadanaAssetAllocation reksadanaAssetAllocation) {
        this.reksadanaAssetAllocations.remove(reksadanaAssetAllocation);
        reksadanaAssetAllocation.setReksadana(null);
        return this;
    }

    public void setReksadanaAssetAllocations(Set<ReksadanaAssetAllocation> reksadanaAssetAllocations) {
        this.reksadanaAssetAllocations = reksadanaAssetAllocations;
    }

    public Set<ReksadanaTransaction> getReksadanaTransactions() {
        return reksadanaTransactions;
    }

    public Reksadana reksadanaTransactions(Set<ReksadanaTransaction> reksadanaTransactions) {
        this.reksadanaTransactions = reksadanaTransactions;
        return this;
    }

    public Reksadana addReksadanaTransaction(ReksadanaTransaction reksadanaTransaction) {
        this.reksadanaTransactions.add(reksadanaTransaction);
        reksadanaTransaction.setReksadana(this);
        return this;
    }

    public Reksadana removeReksadanaTransaction(ReksadanaTransaction reksadanaTransaction) {
        this.reksadanaTransactions.remove(reksadanaTransaction);
        reksadanaTransaction.setReksadana(null);
        return this;
    }

    public void setReksadanaTransactions(Set<ReksadanaTransaction> reksadanaTransactions) {
        this.reksadanaTransactions = reksadanaTransactions;
    }

    public Set<ReksadanaAsset> getReksadanaAssets() {
        return reksadanaAssets;
    }

    public Reksadana reksadanaAssets(Set<ReksadanaAsset> reksadanaAssets) {
        this.reksadanaAssets = reksadanaAssets;
        return this;
    }

    public Reksadana addReksadanaAsset(ReksadanaAsset reksadanaAsset) {
        this.reksadanaAssets.add(reksadanaAsset);
        reksadanaAsset.setReksadana(this);
        return this;
    }

    public Reksadana removeReksadanaAsset(ReksadanaAsset reksadanaAsset) {
        this.reksadanaAssets.remove(reksadanaAsset);
        reksadanaAsset.setReksadana(null);
        return this;
    }

    public void setReksadanaAssets(Set<ReksadanaAsset> reksadanaAssets) {
        this.reksadanaAssets = reksadanaAssets;
    }

    public Set<ReksadanaSwitching> getSourceReks() {
        return sourceReks;
    }

    public Reksadana sourceReks(Set<ReksadanaSwitching> reksadanaSwitchings) {
        this.sourceReks = reksadanaSwitchings;
        return this;
    }

    public Reksadana addSourceRek(ReksadanaSwitching reksadanaSwitching) {
        this.sourceReks.add(reksadanaSwitching);
        reksadanaSwitching.setReksaSource(this);
        return this;
    }

    public Reksadana removeSourceRek(ReksadanaSwitching reksadanaSwitching) {
        this.sourceReks.remove(reksadanaSwitching);
        reksadanaSwitching.setReksaSource(null);
        return this;
    }

    public void setSourceReks(Set<ReksadanaSwitching> reksadanaSwitchings) {
        this.sourceReks = reksadanaSwitchings;
    }

    public Set<ReksadanaSwitching> getTargetReks() {
        return targetReks;
    }

    public Reksadana targetReks(Set<ReksadanaSwitching> reksadanaSwitchings) {
        this.targetReks = reksadanaSwitchings;
        return this;
    }

    public Reksadana addTargetRek(ReksadanaSwitching reksadanaSwitching) {
        this.targetReks.add(reksadanaSwitching);
        reksadanaSwitching.setReksaTarget(this);
        return this;
    }

    public Reksadana removeTargetRek(ReksadanaSwitching reksadanaSwitching) {
        this.targetReks.remove(reksadanaSwitching);
        reksadanaSwitching.setReksaTarget(null);
        return this;
    }

    public void setTargetReks(Set<ReksadanaSwitching> reksadanaSwitchings) {
        this.targetReks = reksadanaSwitchings;
    }

    public Set<AccountReksadana> getAccountReksadanas() {
        return accountReksadanas;
    }

    public Reksadana accountReksadanas(Set<AccountReksadana> accountReksadanas) {
        this.accountReksadanas = accountReksadanas;
        return this;
    }

    public Reksadana addAccountReksadana(AccountReksadana accountReksadana) {
        this.accountReksadanas.add(accountReksadana);
        accountReksadana.setReksadana(this);
        return this;
    }

    public Reksadana removeAccountReksadana(AccountReksadana accountReksadana) {
        this.accountReksadanas.remove(accountReksadana);
        accountReksadana.setReksadana(null);
        return this;
    }

    public void setAccountReksadanas(Set<AccountReksadana> accountReksadanas) {
        this.accountReksadanas = accountReksadanas;
    }

    public JenisReksadana getJenisReksadana() {
        return jenisReksadana;
    }

    public Reksadana jenisReksadana(JenisReksadana jenisReksadana) {
        this.jenisReksadana = jenisReksadana;
        return this;
    }

    public void setJenisReksadana(JenisReksadana jenisReksadana) {
        this.jenisReksadana = jenisReksadana;
    }

    public KategoriReksadana getKategoriReksadana() {
        return kategoriReksadana;
    }

    public Reksadana kategoriReksadana(KategoriReksadana kategoriReksadana) {
        this.kategoriReksadana = kategoriReksadana;
        return this;
    }

    public void setKategoriReksadana(KategoriReksadana kategoriReksadana) {
        this.kategoriReksadana = kategoriReksadana;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Reksadana)) {
            return false;
        }
        return id != null && id.equals(((Reksadana) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Reksadana{" +
            "id=" + getId() +
            ", kodeReksadana='" + getKodeReksadana() + "'" +
            ", namaReksadana='" + getNamaReksadana() + "'" +
            ", isinCode='" + getIsinCode() + "'" +
            ", tanggalPeluncuran='" + getTanggalPeluncuran() + "'" +
            ", aum=" + getAum() +
            ", unit=" + getUnit() +
            ", lastPosDate='" + getLastPosDate() + "'" +
            ", biayaPembelian=" + getBiayaPembelian() +
            ", biayaPenjualan=" + getBiayaPenjualan() +
            ", biayaSwitching=" + getBiayaSwitching() +
            ", notes='" + getNotes() + "'" +
            ", status='" + getStatus() + "'" +
            ", nav=" + getNav() +
            ", barometer=" + getBarometer() +
            ", currencyId=" + getCurrencyId() +
            ", issuerId=" + getIssuerId() +
            ", custodyId=" + getCustodyId() +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            "}";
    }
}
