package id.tech.cakra.investamart.service.dto;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link id.tech.cakra.investamart.domain.ReksadanaSwitching} entity.
 */
public class ReksadanaSwitchingDTO implements Serializable {

    private Long id;

    @Size(max = 10)
    private String orderNo;

    private ZonedDateTime orderTime;

    private ZonedDateTime approveTime;

    private Double amount;

    private Double charges;

    private Double netAmount;

    @Size(max = 1)
    private String status;

    private Long accountId;

    private Long reksadanaId;

    private Long targetReksadanaId;

    private Long currencyId;

    private Long buyOrderId;

    private Long sellOrderId;

    private LocalDate createSystemDate;

    private ZonedDateTime createDate;

    private Long createUserId;

    private LocalDate lastModificationSystemDate;

    private ZonedDateTime lastModificationDate;

    private Long lastModificationUserId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ZonedDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public ZonedDateTime getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(ZonedDateTime approveTime) {
        this.approveTime = approveTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getReksadanaId() {
        return reksadanaId;
    }

    public void setReksadanaId(Long reksadanaId) {
        this.reksadanaId = reksadanaId;
    }

    public Long getTargetReksadanaId() {
        return targetReksadanaId;
    }

    public void setTargetReksadanaId(Long targetReksadanaId) {
        this.targetReksadanaId = targetReksadanaId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReksadanaSwitchingDTO reksadanaSwitchingDTO = (ReksadanaSwitchingDTO) o;
        if (reksadanaSwitchingDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reksadanaSwitchingDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReksadanaSwitchingDTO{" +
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
