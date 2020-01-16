package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.VisitorRegisterAccountDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link VisitorRegisterAccount} and its DTO {@link VisitorRegisterAccountDTO}.
 */
@Mapper(componentModel = "spring", uses = {VisitorMapper.class})
public interface VisitorRegisterAccountMapper extends EntityMapper<VisitorRegisterAccountDTO, VisitorRegisterAccount> {

    @Mapping(source = "visitor.id", target = "visitorId")
    VisitorRegisterAccountDTO toDto(VisitorRegisterAccount visitorRegisterAccount);

    @Mapping(source = "visitorId", target = "visitor")
    VisitorRegisterAccount toEntity(VisitorRegisterAccountDTO visitorRegisterAccountDTO);

    default VisitorRegisterAccount fromId(Long id) {
        if (id == null) {
            return null;
        }
        VisitorRegisterAccount visitorRegisterAccount = new VisitorRegisterAccount();
        visitorRegisterAccount.setId(id);
        return visitorRegisterAccount;
    }
}
