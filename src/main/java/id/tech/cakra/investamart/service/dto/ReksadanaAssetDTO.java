package id.tech.cakra.investamart.service.dto;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link id.tech.cakra.investamart.domain.ReksadanaAsset} entity.
 */
public class ReksadanaAssetDTO implements Serializable {

    private Long id;

    private LocalDate valueDate;

    private BigDecimal aum;

    private BigDecimal unit;

    private BigDecimal nav;

    private LocalDate createSystemDate;

    private ZonedDateTime createDate;

    private Long createUserId;

    private LocalDate lastModificationSystemDate;

    private ZonedDateTime lastModificationDate;

    private Long lastModificationUserId;


    private Long reksadanaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
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

    public BigDecimal getNav() {
        return nav;
    }

    public void setNav(BigDecimal nav) {
        this.nav = nav;
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

    public Long getReksadanaId() {
        return reksadanaId;
    }

    public void setReksadanaId(Long reksadanaId) {
        this.reksadanaId = reksadanaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReksadanaAssetDTO reksadanaAssetDTO = (ReksadanaAssetDTO) o;
        if (reksadanaAssetDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reksadanaAssetDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReksadanaAssetDTO{" +
            "id=" + getId() +
            ", valueDate='" + getValueDate() + "'" +
            ", aum=" + getAum() +
            ", unit=" + getUnit() +
            ", nav=" + getNav() +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            ", reksadana=" + getReksadanaId() +
            "}";
    }
}
