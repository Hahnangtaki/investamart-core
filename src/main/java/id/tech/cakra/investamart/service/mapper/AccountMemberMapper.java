package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.AccountMemberDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccountMember} and its DTO {@link AccountMemberDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AccountMemberMapper extends EntityMapper<AccountMemberDTO, AccountMember> {


    @Mapping(target = "accountAddresses", ignore = true)
    @Mapping(target = "removeAccountAddress", ignore = true)
    @Mapping(target = "accountAuthorizes", ignore = true)
    @Mapping(target = "removeAccountAuthorize", ignore = true)
    @Mapping(target = "accountReksadanas", ignore = true)
    @Mapping(target = "removeAccountReksadana", ignore = true)
    @Mapping(target = "accountBanks", ignore = true)
    @Mapping(target = "removeAccountBank", ignore = true)
    @Mapping(target = "accountInstitution", ignore = true)
    @Mapping(target = "accountIndividu", ignore = true)
    AccountMember toEntity(AccountMemberDTO accountMemberDTO);

    default AccountMember fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountMember accountMember = new AccountMember();
        accountMember.setId(id);
        return accountMember;
    }
}
