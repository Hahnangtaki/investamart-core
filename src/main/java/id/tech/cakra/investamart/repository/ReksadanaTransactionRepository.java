package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.ReksadanaTransaction;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ReksadanaTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReksadanaTransactionRepository extends JpaRepository<ReksadanaTransaction, Long> {

}
