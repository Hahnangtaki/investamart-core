package id.tech.cakra.investamart.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A ReksadanaSwitching.
 */
@Entity
@Table(name = "reksadana_switching")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ReksadanaSwitching implements Serializable {

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

    @Column(name = "amount")
    private Double amount;

    @Column(name = "charges")
    private Double charges;

    @Column(name = "net_amount")
    private Double netAmount;

    @Size(max = 1)
    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "reksadana_id")
    private Long reksadanaId;

    @Column(name = "target_reksadana_id")
    private Long targetReksadanaId;

    @Column(name = "currency_id")
    private Long currencyId;

    @Column(name = "buy_order_id")
    private Long buyOrderId;

    @Column(name = "sell_order_id")
    private Long sellOrderId;

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

    public String getOrderNo() {
        return orderNo;
    }

    public ReksadanaSwitching orderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ZonedDateTime getOrderTime() {
        return orderTime;
    }

    public ReksadanaSwitching orderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public void setOrderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public ZonedDateTime getApproveTime() {
        return approveTime;
    }

    public ReksadanaSwitching approveTime(ZonedDateTime approveTime) {
        this.approveTime = approveTime;
        return this;
    }

    public void setApproveTime(ZonedDateTime approveTime) {
        this.approveTime = approveTime;
    }

    public Double getAmount() {
        return amount;
    }

    public ReksadanaSwitching amount(Double amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCharges() {
        return charges;
    }

    public ReksadanaSwitching charges(Double charges) {
        this.charges = charges;
        return this;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public ReksadanaSwitching netAmount(Double netAmount) {
        this.netAmount = netAmount;
        return this;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public String getStatus() {
        return status;
    }

    public ReksadanaSwitching status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public ReksadanaSwitching accountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getReksadanaId() {
        return reksadanaId;
    }

    public ReksadanaSwitching reksadanaId(Long reksadanaId) {
        this.reksadanaId = reksadanaId;
        return this;
    }

    public void setReksadanaId(Long reksadanaId) {
        this.reksadanaId = reksadanaId;
    }

    public Long getTargetReksadanaId() {
        return targetReksadanaId;
    }

    public ReksadanaSwitching targetReksadanaId(Long targetReksadanaId) {
        this.targetReksadanaId = targetReksadanaId;
        return this;
    }

    public void setTargetReksadanaId(Long targetReksadanaId) {
        this.targetReksadanaId = targetReksadanaId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public ReksadanaSwitching currencyId(Long currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public ReksadanaSwitching buyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
        return this;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public ReksadanaSwitching sellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
        return this;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public ReksadanaSwitching createSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
        return this;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public ReksadanaSwitching createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public ReksadanaSwitching createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public ReksadanaSwitching lastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
        return this;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public ReksadanaSwitching lastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public ReksadanaSwitching lastModificationUserId(Long lastModificationUserId) {
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
        if (!(o instanceof ReksadanaSwitching)) {
            return false;
        }
        return id != null && id.equals(((ReksadanaSwitching) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ReksadanaSwitching{" +
            "id=" + getId() +
            ", orderNo='" + getOrderNo() + "'" +
            ", orderTime='" + getOrderTime() + "'" +
            ", approveTime='" + getApproveTime() + "'" +
            ", amount=" + getAmount() +
            ", charges=" + getCharges() +
            ", netAmount=" + getNetAmount() +
            ", status='" + getStatus() + "'" +
            ", accountId=" + getAccountId() +
            ", reksadanaId=" + getReksadanaId() +
            ", targetReksadanaId=" + getTargetReksadanaId() +
            ", currencyId=" + getCurrencyId() +
            ", buyOrderId=" + getBuyOrderId() +
            ", sellOrderId=" + getSellOrderId() +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            "}";
    }
}
