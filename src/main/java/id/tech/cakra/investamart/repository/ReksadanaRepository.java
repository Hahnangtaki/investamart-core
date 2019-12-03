package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.Reksadana;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Reksadana entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReksadanaRepository extends JpaRepository<Reksadana, Long> {

}
