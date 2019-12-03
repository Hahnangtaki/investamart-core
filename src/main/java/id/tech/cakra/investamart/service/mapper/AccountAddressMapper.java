package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.AccountAddressDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AccountAddress} and its DTO {@link AccountAddressDTO}.
 */
@Mapper(componentModel = "spring", uses = {AccountMemberMapper.class})
public interface AccountAddressMapper extends EntityMapper<AccountAddressDTO, AccountAddress> {

    @Mapping(source = "accountMember.id", target = "accountMemberId")
    AccountAddressDTO toDto(AccountAddress accountAddress);

    @Mapping(source = "accountMemberId", target = "accountMember")
    AccountAddress toEntity(AccountAddressDTO accountAddressDTO);

    default AccountAddress fromId(Long id) {
        if (id == null) {
            return null;
        }
        AccountAddress accountAddress = new AccountAddress();
        accountAddress.setId(id);
        return accountAddress;
    }
}
