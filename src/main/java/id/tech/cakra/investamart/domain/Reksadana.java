package id.tech.cakra.investamart.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

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

    @Size(max = 10)
    @Column(name = "kode_reksadana", length = 10)
    private String kodeReksadana;

    @Size(max = 50)
    @Column(name = "nama_reksadana", length = 50)
    private String namaReksadana;

    @Size(max = 20)
    @Column(name = "isin_code", length = 20)
    private String isinCode;

    @Column(name = "tanggal_peluncuran")
    private LocalDate tanggalPeluncuran;

    @Column(name = "aum")
    private Double aum;

    @Column(name = "unit")
    private Double unit;

    @Column(name = "last_pos_date")
    private LocalDate lastPosDate;

    @Column(name = "biaya_pembelian")
    private Double biayaPembelian;

    @Column(name = "biaya_penjualan")
    private Double biayaPenjualan;

    @Column(name = "biaya_switching")
    private Double biayaSwitching;

    @Column(name = "notes")
    private String notes;

    @Size(max = 1)
    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "currency_id")
    private Long currencyId;

    @Column(name = "issuer_id")
    private Long issuerId;

    @Column(name = "custody_id")
    private Long custodyId;

    @Column(name = "jenis_reksadana_id")
    private Long jenisReksadanaId;

    @Column(name = "kategori_reksadana_id")
    private Long kategoriReksadanaId;

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

    public Double getAum() {
        return aum;
    }

    public Reksadana aum(Double aum) {
        this.aum = aum;
        return this;
    }

    public void setAum(Double aum) {
        this.aum = aum;
    }

    public Double getUnit() {
        return unit;
    }

    public Reksadana unit(Double unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(Double unit) {
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

    public Double getBiayaPembelian() {
        return biayaPembelian;
    }

    public Reksadana biayaPembelian(Double biayaPembelian) {
        this.biayaPembelian = biayaPembelian;
        return this;
    }

    public void setBiayaPembelian(Double biayaPembelian) {
        this.biayaPembelian = biayaPembelian;
    }

    public Double getBiayaPenjualan() {
        return biayaPenjualan;
    }

    public Reksadana biayaPenjualan(Double biayaPenjualan) {
        this.biayaPenjualan = biayaPenjualan;
        return this;
    }

    public void setBiayaPenjualan(Double biayaPenjualan) {
        this.biayaPenjualan = biayaPenjualan;
    }

    public Double getBiayaSwitching() {
        return biayaSwitching;
    }

    public Reksadana biayaSwitching(Double biayaSwitching) {
        this.biayaSwitching = biayaSwitching;
        return this;
    }

    public void setBiayaSwitching(Double biayaSwitching) {
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

    public Long getJenisReksadanaId() {
        return jenisReksadanaId;
    }

    public Reksadana jenisReksadanaId(Long jenisReksadanaId) {
        this.jenisReksadanaId = jenisReksadanaId;
        return this;
    }

    public void setJenisReksadanaId(Long jenisReksadanaId) {
        this.jenisReksadanaId = jenisReksadanaId;
    }

    public Long getKategoriReksadanaId() {
        return kategoriReksadanaId;
    }

    public Reksadana kategoriReksadanaId(Long kategoriReksadanaId) {
        this.kategoriReksadanaId = kategoriReksadanaId;
        return this;
    }

    public void setKategoriReksadanaId(Long kategoriReksadanaId) {
        this.kategoriReksadanaId = kategoriReksadanaId;
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
            ", currencyId=" + getCurrencyId() +
            ", issuerId=" + getIssuerId() +
            ", custodyId=" + getCustodyId() +
            ", jenisReksadanaId=" + getJenisReksadanaId() +
            ", kategoriReksadanaId=" + getKategoriReksadanaId() +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            "}";
    }
}
