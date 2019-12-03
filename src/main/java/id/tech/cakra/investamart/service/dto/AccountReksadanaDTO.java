package id.tech.cakra.investamart.service.dto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link id.tech.cakra.investamart.domain.AccountReksadana} entity.
 */
public class AccountReksadanaDTO implements Serializable {

    private Long id;

    private BigDecimal costPrice;

    private BigDecimal qtyOnHand;

    private BigDecimal qtyDeposit;

    private BigDecimal qtyWithdraw;

    private BigDecimal profitLoss;


    private Long reksadanaId;

    private Long accountMemberId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public BigDecimal getQtyDeposit() {
        return qtyDeposit;
    }

    public void setQtyDeposit(BigDecimal qtyDeposit) {
        this.qtyDeposit = qtyDeposit;
    }

    public BigDecimal getQtyWithdraw() {
        return qtyWithdraw;
    }

    public void setQtyWithdraw(BigDecimal qtyWithdraw) {
        this.qtyWithdraw = qtyWithdraw;
    }

    public BigDecimal getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(BigDecimal profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Long getReksadanaId() {
        return reksadanaId;
    }

    public void setReksadanaId(Long reksadanaId) {
        this.reksadanaId = reksadanaId;
    }

    public Long getAccountMemberId() {
        return accountMemberId;
    }

    public void setAccountMemberId(Long accountMemberId) {
        this.accountMemberId = accountMemberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccountReksadanaDTO accountReksadanaDTO = (AccountReksadanaDTO) o;
        if (accountReksadanaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), accountReksadanaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AccountReksadanaDTO{" +
            "id=" + getId() +
            ", costPrice=" + getCostPrice() +
            ", qtyOnHand=" + getQtyOnHand() +
            ", qtyDeposit=" + getQtyDeposit() +
            ", qtyWithdraw=" + getQtyWithdraw() +
            ", profitLoss=" + getProfitLoss() +
            ", reksadana=" + getReksadanaId() +
            ", accountMember=" + getAccountMemberId() +
            "}";
    }
}
