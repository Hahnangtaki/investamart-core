package id.tech.cakra.investamart.service.dto;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link id.tech.cakra.investamart.domain.Reksadana} entity.
 */
public class ReksadanaDTO implements Serializable {

    private Long id;

    @Size(max = 20)
    private String kodeReksadana;

    @Size(max = 100)
    private String namaReksadana;

    @Size(max = 20)
    private String isinCode;

    private LocalDate tanggalPeluncuran;

    private BigDecimal aum;

    private BigDecimal unit;

    private LocalDate lastPosDate;

    private BigDecimal biayaPembelian;

    private BigDecimal biayaPenjualan;

    private BigDecimal biayaSwitching;

    private String notes;

    @Size(max = 1)
    private String status;

    private BigDecimal nav;

    private Double barometer;

    private Long currencyId;

    private Long issuerId;

    private Long custodyId;

    private LocalDate createSystemDate;

    private ZonedDateTime createDate;

    private Long createUserId;

    private LocalDate lastModificationSystemDate;

    private ZonedDateTime lastModificationDate;

    private Long lastModificationUserId;


    private Long jenisReksadanaId;

    private Long kategoriReksadanaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeReksadana() {
        return kodeReksadana;
    }

    public void setKodeReksadana(String kodeReksadana) {
        this.kodeReksadana = kodeReksadana;
    }

    public String getNamaReksadana() {
        return namaReksadana;
    }

    public void setNamaReksadana(String namaReksadana) {
        this.namaReksadana = namaReksadana;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public LocalDate getTanggalPeluncuran() {
        return tanggalPeluncuran;
    }

    public void setTanggalPeluncuran(LocalDate tanggalPeluncuran) {
        this.tanggalPeluncuran = tanggalPeluncuran;
    }

    public BigDecimal getAum() {
        return aum;
    }

    public void setAum(BigDecimal aum) {
        this.aum = aum;
    }

    public BigDecimal getUnit() {
        return unit;
    }

    public void setUnit(BigDecimal unit) {
        this.unit = unit;
    }

    public LocalDate getLastPosDate() {
        return lastPosDate;
    }

    public void setLastPosDate(LocalDate lastPosDate) {
        this.lastPosDate = lastPosDate;
    }

    public BigDecimal getBiayaPembelian() {
        return biayaPembelian;
    }

    public void setBiayaPembelian(BigDecimal biayaPembelian) {
        this.biayaPembelian = biayaPembelian;
    }

    public BigDecimal getBiayaPenjualan() {
        return biayaPenjualan;
    }

    public void setBiayaPenjualan(BigDecimal biayaPenjualan) {
        this.biayaPenjualan = biayaPenjualan;
    }

    public BigDecimal getBiayaSwitching() {
        return biayaSwitching;
    }

    public void setBiayaSwitching(BigDecimal biayaSwitching) {
        this.biayaSwitching = biayaSwitching;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getNav() {
        return nav;
    }

    public void setNav(BigDecimal nav) {
        this.nav = nav;
    }

    public Double getBarometer() {
        return barometer;
    }

    public void setBarometer(Double barometer) {
        this.barometer = barometer;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(Long issuerId) {
        this.issuerId = issuerId;
    }

    public Long getCustodyId() {
        return custodyId;
    }

    public void setCustodyId(Long custodyId) {
        this.custodyId = custodyId;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public void setLastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public Long getJenisReksadanaId() {
        return jenisReksadanaId;
    }

    public void setJenisReksadanaId(Long jenisReksadanaId) {
        this.jenisReksadanaId = jenisReksadanaId;
    }

    public Long getKategoriReksadanaId() {
        return kategoriReksadanaId;
    }

    public void setKategoriReksadanaId(Long kategoriReksadanaId) {
        this.kategoriReksadanaId = kategoriReksadanaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReksadanaDTO reksadanaDTO = (ReksadanaDTO) o;
        if (reksadanaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reksadanaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReksadanaDTO{" +
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
            ", jenisReksadana=" + getJenisReksadanaId() +
            ", kategoriReksadana=" + getKategoriReksadanaId() +
            "}";
    }
}
