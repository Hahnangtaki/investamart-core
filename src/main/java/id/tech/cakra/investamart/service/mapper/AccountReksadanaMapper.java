package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.AccountReksadanaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccountReksadana} and its DTO {@link AccountReksadanaDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReksadanaMapper.class, AccountMemberMapper.class})
public interface AccountReksadanaMapper extends EntityMapper<AccountReksadanaDTO, AccountReksadana> {

    @Mapping(source = "reksadana.id", target = "reksadanaId")
    @Mapping(source = "accountMember.id", target = "accountMemberId")
    AccountReksadanaDTO toDto(AccountReksadana accountReksadana);

    @Mapping(source = "reksadanaId", target = "reksadana")
    @Mapping(source = "accountMemberId", target = "accountMember")
    AccountReksadana toEntity(AccountReksadanaDTO accountReksadanaDTO);

    default AccountReksadana fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountReksadana accountReksadana = new AccountReksadana();
        accountReksadana.setId(id);
        return accountReksadana;
    }
}
