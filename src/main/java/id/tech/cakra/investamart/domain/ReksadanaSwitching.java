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

    @OneToOne
    @JoinColumn(unique = true)
    private ReksadanaTransaction orderBuy;

    @OneToOne
    @JoinColumn(unique = true)
    private ReksadanaTransaction orderSell;

    @OneToMany(mappedBy = "switching")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ReksadanaTransaction> switchingOrders = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("sourceReks")
    private Reksadana reksaSource;

    @ManyToOne
    @JsonIgnoreProperties("targetReks")
    private Reksadana reksaTarget;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public ReksadanaSwitching amount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public ReksadanaSwitching charges(BigDecimal charges) {
        this.charges = charges;
        return this;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public ReksadanaSwitching netAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
        return this;
    }

    public void setNetAmount(BigDecimal netAmount) {
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

    public ReksadanaTransaction getOrderBuy() {
        return orderBuy;
    }

    public ReksadanaSwitching orderBuy(ReksadanaTransaction reksadanaTransaction) {
        this.orderBuy = reksadanaTransaction;
        return this;
    }

    public void setOrderBuy(ReksadanaTransaction reksadanaTransaction) {
        this.orderBuy = reksadanaTransaction;
    }

    public ReksadanaTransaction getOrderSell() {
        return orderSell;
    }

    public ReksadanaSwitching orderSell(ReksadanaTransaction reksadanaTransaction) {
        this.orderSell = reksadanaTransaction;
        return this;
    }

    public void setOrderSell(ReksadanaTransaction reksadanaTransaction) {
        this.orderSell = reksadanaTransaction;
    }

    public Set<ReksadanaTransaction> getSwitchingOrders() {
        return switchingOrders;
    }

    public ReksadanaSwitching switchingOrders(Set<ReksadanaTransaction> reksadanaTransactions) {
        this.switchingOrders = reksadanaTransactions;
        return this;
    }

    public ReksadanaSwitching addSwitchingOrder(ReksadanaTransaction reksadanaTransaction) {
        this.switchingOrders.add(reksadanaTransaction);
        reksadanaTransaction.setSwitching(this);
        return this;
    }

    public ReksadanaSwitching removeSwitchingOrder(ReksadanaTransaction reksadanaTransaction) {
        this.switchingOrders.remove(reksadanaTransaction);
        reksadanaTransaction.setSwitching(null);
        return this;
    }

    public void setSwitchingOrders(Set<ReksadanaTransaction> reksadanaTransactions) {
        this.switchingOrders = reksadanaTransactions;
    }

    public Reksadana getReksaSource() {
        return reksaSource;
    }

    public ReksadanaSwitching reksaSource(Reksadana reksadana) {
        this.reksaSource = reksadana;
        return this;
    }

    public void setReksaSource(Reksadana reksadana) {
        this.reksaSource = reksadana;
    }

    public Reksadana getReksaTarget() {
        return reksaTarget;
    }

    public ReksadanaSwitching reksaTarget(Reksadana reksadana) {
        this.reksaTarget = reksadana;
        return this;
    }

    public void setReksaTarget(Reksadana reksadana) {
        this.reksaTarget = reksadana;
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
