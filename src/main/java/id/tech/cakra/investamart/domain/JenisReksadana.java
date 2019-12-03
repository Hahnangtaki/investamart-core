package id.tech.cakra.investamart.domain;
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
 * A JenisReksadana.
 */
@Entity
@Table(name = "jenis_reksadana")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class JenisReksadana implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Size(max = 10)
    @Column(name = "kode_jenis", length = 10)
    private String kodeJenis;

    @Size(max = 50)
    @Column(name = "nama_jenis", length = 50)
    private String namaJenis;

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

    @OneToMany(mappedBy = "jenisReksadana")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Reksadana> reksadanas = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodeJenis() {
        return kodeJenis;
    }

    public JenisReksadana kodeJenis(String kodeJenis) {
        this.kodeJenis = kodeJenis;
        return this;
    }

    public void setKodeJenis(String kodeJenis) {
        this.kodeJenis = kodeJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public JenisReksadana namaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
        return this;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public LocalDate getCreateSystemDate() {
        return createSystemDate;
    }

    public JenisReksadana createSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
        return this;
    }

    public void setCreateSystemDate(LocalDate createSystemDate) {
        this.createSystemDate = createSystemDate;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public JenisReksadana createDate(ZonedDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public JenisReksadana createUserId(Long createUserId) {
        this.createUserId = createUserId;
        return this;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDate getLastModificationSystemDate() {
        return lastModificationSystemDate;
    }

    public JenisReksadana lastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
        return this;
    }

    public void setLastModificationSystemDate(LocalDate lastModificationSystemDate) {
        this.lastModificationSystemDate = lastModificationSystemDate;
    }

    public ZonedDateTime getLastModificationDate() {
        return lastModificationDate;
    }

    public JenisReksadana lastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public void setLastModificationDate(ZonedDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Long getLastModificationUserId() {
        return lastModificationUserId;
    }

    public JenisReksadana lastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
        return this;
    }

    public void setLastModificationUserId(Long lastModificationUserId) {
        this.lastModificationUserId = lastModificationUserId;
    }

    public Set<Reksadana> getReksadanas() {
        return reksadanas;
    }

    public JenisReksadana reksadanas(Set<Reksadana> reksadanas) {
        this.reksadanas = reksadanas;
        return this;
    }

    public JenisReksadana addReksadana(Reksadana reksadana) {
        this.reksadanas.add(reksadana);
        reksadana.setJenisReksadana(this);
        return this;
    }

    public JenisReksadana removeReksadana(Reksadana reksadana) {
        this.reksadanas.remove(reksadana);
        reksadana.setJenisReksadana(null);
        return this;
    }

    public void setReksadanas(Set<Reksadana> reksadanas) {
        this.reksadanas = reksadanas;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JenisReksadana)) {
            return false;
        }
        return id != null && id.equals(((JenisReksadana) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "JenisReksadana{" +
            "id=" + getId() +
            ", kodeJenis='" + getKodeJenis() + "'" +
            ", namaJenis='" + getNamaJenis() + "'" +
            ", createSystemDate='" + getCreateSystemDate() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", createUserId=" + getCreateUserId() +
            ", lastModificationSystemDate='" + getLastModificationSystemDate() + "'" +
            ", lastModificationDate='" + getLastModificationDate() + "'" +
            ", lastModificationUserId=" + getLastModificationUserId() +
            "}";
    }
}
