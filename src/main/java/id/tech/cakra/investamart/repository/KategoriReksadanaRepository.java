package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.KategoriReksadana;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the KategoriReksadana entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KategoriReksadanaRepository extends JpaRepository<KategoriReksadana, Long> {

}
