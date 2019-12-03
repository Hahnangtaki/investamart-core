package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.AccountAddress;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountAddress entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountAddressRepository extends JpaRepository<AccountAddress, Long> {

}
