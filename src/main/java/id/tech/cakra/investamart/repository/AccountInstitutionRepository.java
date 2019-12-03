package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.AccountInstitution;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountInstitution entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountInstitutionRepository extends JpaRepository<AccountInstitution, Long> {

}
