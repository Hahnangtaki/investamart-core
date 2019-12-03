package id.tech.cakra.investamart.repository;
import id.tech.cakra.investamart.domain.AccountMember;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountMember entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountMemberRepository extends JpaRepository<AccountMember, Long> {

}
