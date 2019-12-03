package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.ReksadanaAsset;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the ReksadanaAsset entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReksadanaAssetRepository extends JpaRepository<ReksadanaAsset, Long> {

}
