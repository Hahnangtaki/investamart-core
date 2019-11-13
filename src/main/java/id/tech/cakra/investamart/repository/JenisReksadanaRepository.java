package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.JenisReksadana;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JenisReksadana entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JenisReksadanaRepository extends JpaRepository<JenisReksadana, Long> {

}
