package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.AccountAuthorize;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountAuthorize entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountAuthorizeRepository extends JpaRepository<AccountAuthorize, Long> {

}
