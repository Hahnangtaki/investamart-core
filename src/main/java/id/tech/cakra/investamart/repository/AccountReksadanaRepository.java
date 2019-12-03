package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.AccountReksadana;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountReksadana entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountReksadanaRepository extends JpaRepository<AccountReksadana, Long> {

}
