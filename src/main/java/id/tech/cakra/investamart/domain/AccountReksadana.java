package id.tech.cakra.investamart.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A AccountReksadana.
 */
@Entity
@Table(name = "account_reksadana")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountReksadana implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "cost_price", precision = 21, scale = 2)
    private BigDecimal costPrice;

    @Column(name = "qty_on_hand", precision = 21, scale = 2)
    private BigDecimal qtyOnHand;

    @Column(name = "qty_deposit", precision = 21, scale = 2)
    private BigDecimal qtyDeposit;

    @Column(name = "qty_withdraw", precision = 21, scale = 2)
    private BigDecimal qtyWithdraw;

    @Column(name = "profit_loss", precision = 21, scale = 2)
    private BigDecimal profitLoss;

    @ManyToOne
    @JsonIgnoreProperties("accountReksadanas")
    private Reksadana reksadana;

    @ManyToOne
    @JsonIgnoreProperties("accountReksadanas")
    private AccountMember accountMember;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public AccountReksadana costPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
        return this;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getQtyOnHand() {
        return qtyOnHand;
    }

    public AccountReksadana qtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
        return this;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getQtyDeposit() {
        return qtyDeposit;
    }

    public AccountReksadana qtyDeposit(BigDecimal qtyDeposit) {
        this.qtyDeposit = qtyDeposit;
        return this;
    }

    public void setQtyDeposit(BigDecimal qtyDeposit) {
        this.qtyDeposit = qtyDeposit;
    }

    public BigDecimal getQtyWithdraw() {
        return qtyWithdraw;
    }

    public AccountReksadana qtyWithdraw(BigDecimal qtyWithdraw) {
        this.qtyWithdraw = qtyWithdraw;
        return this;
    }

    public void setQtyWithdraw(BigDecimal qtyWithdraw) {
        this.qtyWithdraw = qtyWithdraw;
    }

    public BigDecimal getProfitLoss() {
        return profitLoss;
    }

    public AccountReksadana profitLoss(BigDecimal profitLoss) {
        this.profitLoss = profitLoss;
        return this;
    }

    public void setProfitLoss(BigDecimal profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Reksadana getReksadana() {
        return reksadana;
    }

    public AccountReksadana reksadana(Reksadana reksadana) {
        this.reksadana = reksadana;
        return this;
    }

    public void setReksadana(Reksadana reksadana) {
        this.reksadana = reksadana;
    }

    public AccountMember getAccountMember() {
        return accountMember;
    }

    public AccountReksadana accountMember(AccountMember accountMember) {
        this.accountMember = accountMember;
        return this;
    }

    public void setAccountMember(AccountMember accountMember) {
        this.accountMember = accountMember;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountReksadana)) {
            return false;
        }
        return id != null && id.equals(((AccountReksadana) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "AccountReksadana{" +
            "id=" + getId() +
            ", costPrice=" + getCostPrice() +
            ", qtyOnHand=" + getQtyOnHand() +
            ", qtyDeposit=" + getQtyDeposit() +
            ", qtyWithdraw=" + getQtyWithdraw() +
            ", profitLoss=" + getProfitLoss() +
            "}";
    }
}
