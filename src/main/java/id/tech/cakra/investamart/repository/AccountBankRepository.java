package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.AccountBank;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountBank entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountBankRepository extends JpaRepository<AccountBank, Long> {

}
