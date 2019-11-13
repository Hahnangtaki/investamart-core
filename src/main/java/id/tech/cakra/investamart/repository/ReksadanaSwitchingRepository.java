package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.ReksadanaSwitching;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ReksadanaSwitching entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReksadanaSwitchingRepository extends JpaRepository<ReksadanaSwitching, Long> {

}
