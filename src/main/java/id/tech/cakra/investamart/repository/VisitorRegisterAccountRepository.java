package id.tech.cakra.investamart.repository;

import id.tech.cakra.investamart.domain.VisitorRegisterAccount;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the VisitorRegisterAccount entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VisitorRegisterAccountRepository extends JpaRepository<VisitorRegisterAccount, Long> {

}
