package id.tech.cakra.investamart.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A ReksadanaAsset.
 */
@Entity
@Table(name = "reksadana_asset")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ReksadanaAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "value_date")
    private LocalDate valueDate;

    @Column(name = "aum", precision = 21, scale = 2)
    private BigDecimal aum;

    @Column(name = "unit", precision = 21, scale = 2)
    private BigDecimal unit;

    @Column(name = "nav", precision = 21, scale = 2)
    private BigDecimal nav;

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

    @ManyToOne
    @JsonIgnoreProperties("reksadanaAssets")
    private Reksadana reksadana;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public ReksadanaAsset valueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
        return this;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public BigDecimal getAum() {
        return aum;
    }

    public ReksadanaAsset aum(BigDecimal aum) {
        this.aum = aum;
        return this;
    }

    public void setAum(BigDecimal aum) {
        this.aum = aum;
    }

    public BigDecimal getUnit() {
        return unit;
    }

    public ReksadanaAsset unit(BigDecimal unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(BigDecimal unit) {
        this.unit = unit;
    }

    public BigDecimal getNav() {
        return nav;
    }

    public ReksadanaAsset nav(BigDecimal nav) {
        this.nav = nav;
        return this;
    }

    public void setNav(BigDecimal nav) {
        this.nav = nav;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public ReksadanaAsset createSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
        return this;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public ReksadanaAsset createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public ReksadanaAsset createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public ReksadanaAsset lastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
        return this;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public ReksadanaAsset lastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public ReksadanaAsset lastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
        return this;
    }

    public void setLastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public Reksadana getReksadana() {
        return reksadana;
    }

    public ReksadanaAsset reksadana(Reksadana reksadana) {
        this.reksadana = reksadana;
        return this;
    }

    public void setReksadana(Reksadana reksadana) {
        this.reksadana = reksadana;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReksadanaAsset)) {
            return false;
        }
        return id != null && id.equals(((ReksadanaAsset) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ReksadanaAsset{" +
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
            "}";
    }
}
