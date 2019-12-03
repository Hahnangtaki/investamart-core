package id.tech.cakra.investamart.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A ReksadanaTransaction.
 */
@Entity
@Table(name = "reksadana_transaction")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ReksadanaTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 10)
    @Column(name = "order_no", length = 10)
    private String orderNo;

    @Column(name = "order_time")
    private ZonedDateTime orderTime;

    @Column(name = "approve_time")
    private ZonedDateTime approveTime;

    @Size(max = 1)
    @Column(name = "order_type", length = 1)
    private String orderType;

    @Column(name = "unit", precision = 21, scale = 2)
    private BigDecimal unit;

    @Column(name = "amount", precision = 21, scale = 2)
    private BigDecimal amount;

    @Column(name = "charges", precision = 21, scale = 2)
    private BigDecimal charges;

    @Column(name = "net_amount", precision = 21, scale = 2)
    private BigDecimal netAmount;

    @Size(max = 1)
    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "currency_id")
    private Long currencyId;

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

    @OneToOne(mappedBy = "orderBuy")
    @JsonIgnore
    private ReksadanaSwitching buy;

    @OneToOne(mappedBy = "orderSell")
    @JsonIgnore
    private ReksadanaSwitching sell;

    @ManyToOne
    @JsonIgnoreProperties("reksadanaTransactions")
    private Reksadana reksadana;

    @ManyToOne
    @JsonIgnoreProperties("switchingOrders")
    private ReksadanaSwitching switching;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public ReksadanaTransaction orderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ZonedDateTime getOrderTime() {
        return orderTime;
    }

    public ReksadanaTransaction orderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public void setOrderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public ZonedDateTime getApproveTime() {
        return approveTime;
    }

    public ReksadanaTransaction approveTime(ZonedDateTime approveTime) {
        this.approveTime = approveTime;
        return this;
    }

    public void setApproveTime(ZonedDateTime approveTime) {
        this.approveTime = approveTime;
    }

    public String getOrderType() {
        return orderType;
    }

    public ReksadanaTransaction orderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getUnit() {
        return unit;
    }

    public ReksadanaTransaction unit(BigDecimal unit) {
        this.unit = unit;
        return this;
    }

    public void setUnit(BigDecimal unit) {
        this.unit = unit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ReksadanaTransaction amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public ReksadanaTransaction charges(BigDecimal charges) {
        this.charges = charges;
        return this;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public ReksadanaTransaction netAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
        return this;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public String getStatus() {
        return status;
    }

    public ReksadanaTransaction status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public ReksadanaTransaction accountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public ReksadanaTransaction currencyId(Long currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public ReksadanaTransaction createSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
        return this;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public ReksadanaTransaction createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public ReksadanaTransaction createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public ReksadanaTransaction lastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
        return this;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public ReksadanaTransaction lastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public ReksadanaTransaction lastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
        return this;
    }

    public void setLastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public ReksadanaSwitching getBuy() {
        return buy;
    }

    public ReksadanaTransaction buy(ReksadanaSwitching reksadanaSwitching) {
        this.buy = reksadanaSwitching;
        return this;
    }

    public void setBuy(ReksadanaSwitching reksadanaSwitching) {
        this.buy = reksadanaSwitching;
    }

    public ReksadanaSwitching getSell() {
        return sell;
    }

    public ReksadanaTransaction sell(ReksadanaSwitching reksadanaSwitching) {
        this.sell = reksadanaSwitching;
        return this;
    }

    public void setSell(ReksadanaSwitching reksadanaSwitching) {
        this.sell = reksadanaSwitching;
    }

    public Reksadana getReksadana() {
        return reksadana;
    }

    public ReksadanaTransaction reksadana(Reksadana reksadana) {
        this.reksadana = reksadana;
        return this;
    }

    public void setReksadana(Reksadana reksadana) {
        this.reksadana = reksadana;
    }

    public ReksadanaSwitching getSwitching() {
        return switching;
    }

    public ReksadanaTransaction switching(ReksadanaSwitching reksadanaSwitching) {
        this.switching = reksadanaSwitching;
        return this;
    }

    public void setSwitching(ReksadanaSwitching reksadanaSwitching) {
        this.switching = reksadanaSwitching;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReksadanaTransaction)) {
            return false;
        }
        return id != null && id.equals(((ReksadanaTransaction) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ReksadanaTransaction{" +
            "id=" + getId() +
            ", orderNo='" + getOrderNo() + "'" +
            ", orderTime='" + getOrderTime() + "'" +
            ", approveTime='" + getApproveTime() + "'" +
            ", orderType='" + getOrderType() + "'" +
            ", unit=" + getUnit() +
            ", amount=" + getAmount() +
            ", charges=" + getCharges() +
            ", netAmount=" + getNetAmount() +
            ", status='" + getStatus() + "'" +
            ", accountId=" + getAccountId() +
            ", currencyId=" + getCurrencyId() +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            "}";
    }
}
