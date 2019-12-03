package id.tech.cakra.investamart.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A AccountMember.
 */
@Entity
@Table(name = "account_member")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AccountMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 10)
    @Column(name = "register_code", length = 10)
    private String registerCode;

    @Size(max = 100)
    @Column(name = "account_name", length = 100)
    private String accountName;

    @Size(max = 1)
    @Column(name = "account_type", length = 1)
    private String accountType;

    @Column(name = "account_angle")
    private Boolean accountAngle;

    @Size(max = 4)
    @Column(name = "ksei_client_code", length = 4)
    private String kseiClientCode;

    @Size(max = 15)
    @Column(name = "ksei_subrek", length = 15)
    private String kseiSubrek;

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

    @OneToMany(mappedBy = "accountMember")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountAddress> accountAddresses = new HashSet<>();

    @OneToMany(mappedBy = "accountMember")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountAuthorize> accountAuthorizes = new HashSet<>();

    @OneToMany(mappedBy = "accountMember")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountReksadana> accountReksadanas = new HashSet<>();

    @OneToMany(mappedBy = "accountMember")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<AccountBank> accountBanks = new HashSet<>();

    @OneToOne(mappedBy = "accountMember")
    @JsonIgnore
    private AccountInstitution accountInstitution;

    @OneToOne(mappedBy = "accountMember")
    @JsonIgnore
    private AccountIndividu accountIndividu;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public AccountMember registerCode(String registerCode) {
        this.registerCode = registerCode;
        return this;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public AccountMember accountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public AccountMember accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Boolean isAccountAngle() {
        return accountAngle;
    }

    public AccountMember accountAngle(Boolean accountAngle) {
        this.accountAngle = accountAngle;
        return this;
    }

    public void setAccountAngle(Boolean accountAngle) {
        this.accountAngle = accountAngle;
    }

    public String getKseiClientCode() {
        return kseiClientCode;
    }

    public AccountMember kseiClientCode(String kseiClientCode) {
        this.kseiClientCode = kseiClientCode;
        return this;
    }

    public void setKseiClientCode(String kseiClientCode) {
        this.kseiClientCode = kseiClientCode;
    }

    public String getKseiSubrek() {
        return kseiSubrek;
    }

    public AccountMember kseiSubrek(String kseiSubrek) {
        this.kseiSubrek = kseiSubrek;
        return this;
    }

    public void setKseiSubrek(String kseiSubrek) {
        this.kseiSubrek = kseiSubrek;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public AccountMember createSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
        return this;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public AccountMember createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public AccountMember createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public AccountMember lastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
        return this;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public AccountMember lastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public AccountMember lastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
        return this;
    }

    public void setLastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public Set<AccountAddress> getAccountAddresses() {
        return accountAddresses;
    }

    public AccountMember accountAddresses(Set<AccountAddress> accountAddresses) {
        this.accountAddresses = accountAddresses;
        return this;
    }

    public AccountMember addAccountAddress(AccountAddress accountAddress) {
        this.accountAddresses.add(accountAddress);
        accountAddress.setAccountMember(this);
        return this;
    }

    public AccountMember removeAccountAddress(AccountAddress accountAddress) {
        this.accountAddresses.remove(accountAddress);
        accountAddress.setAccountMember(null);
        return this;
    }

    public void setAccountAddresses(Set<AccountAddress> accountAddresses) {
        this.accountAddresses = accountAddresses;
    }

    public Set<AccountAuthorize> getAccountAuthorizes() {
        return accountAuthorizes;
    }

    public AccountMember accountAuthorizes(Set<AccountAuthorize> accountAuthorizes) {
        this.accountAuthorizes = accountAuthorizes;
        return this;
    }

    public AccountMember addAccountAuthorize(AccountAuthorize accountAuthorize) {
        this.accountAuthorizes.add(accountAuthorize);
        accountAuthorize.setAccountMember(this);
        return this;
    }

    public AccountMember removeAccountAuthorize(AccountAuthorize accountAuthorize) {
        this.accountAuthorizes.remove(accountAuthorize);
        accountAuthorize.setAccountMember(null);
        return this;
    }

    public void setAccountAuthorizes(Set<AccountAuthorize> accountAuthorizes) {
        this.accountAuthorizes = accountAuthorizes;
    }

    public Set<AccountReksadana> getAccountReksadanas() {
        return accountReksadanas;
    }

    public AccountMember accountReksadanas(Set<AccountReksadana> accountReksadanas) {
        this.accountReksadanas = accountReksadanas;
        return this;
    }

    public AccountMember addAccountReksadana(AccountReksadana accountReksadana) {
        this.accountReksadanas.add(accountReksadana);
        accountReksadana.setAccountMember(this);
        return this;
    }

    public AccountMember removeAccountReksadana(AccountReksadana accountReksadana) {
        this.accountReksadanas.remove(accountReksadana);
        accountReksadana.setAccountMember(null);
        return this;
    }

    public void setAccountReksadanas(Set<AccountReksadana> accountReksadanas) {
        this.accountReksadanas = accountReksadanas;
    }

    public Set<AccountBank> getAccountBanks() {
        return accountBanks;
    }

    public AccountMember accountBanks(Set<AccountBank> accountBanks) {
        this.accountBanks = accountBanks;
        return this;
    }

    public AccountMember addAccountBank(AccountBank accountBank) {
        this.accountBanks.add(accountBank);
        accountBank.setAccountMember(this);
        return this;
    }

    public AccountMember removeAccountBank(AccountBank accountBank) {
        this.accountBanks.remove(accountBank);
        accountBank.setAccountMember(null);
        return this;
    }

    public void setAccountBanks(Set<AccountBank> accountBanks) {
        this.accountBanks = accountBanks;
    }

    public AccountInstitution getAccountInstitution() {
        return accountInstitution;
    }

    public AccountMember accountInstitution(AccountInstitution accountInstitution) {
        this.accountInstitution = accountInstitution;
        return this;
    }

    public void setAccountInstitution(AccountInstitution accountInstitution) {
        this.accountInstitution = accountInstitution;
    }

    public AccountIndividu getAccountIndividu() {
        return accountIndividu;
    }

    public AccountMember accountIndividu(AccountIndividu accountIndividu) {
        this.accountIndividu = accountIndividu;
        return this;
    }

    public void setAccountIndividu(AccountIndividu accountIndividu) {
        this.accountIndividu = accountIndividu;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AccountMember)) {
            return false;
        }
        return id != null && id.equals(((AccountMember) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "AccountMember{" +
            "id=" + getId() +
            ", registerCode='" + getRegisterCode() + "'" +
            ", accountName='" + getAccountName() + "'" +
            ", accountType='" + getAccountType() + "'" +
            ", accountAngle='" + isAccountAngle() + "'" +
            ", kseiClientCode='" + getKseiClientCode() + "'" +
            ", kseiSubrek='" + getKseiSubrek() + "'" +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            "}";
    }
}
