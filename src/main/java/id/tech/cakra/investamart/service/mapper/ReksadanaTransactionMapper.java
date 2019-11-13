package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaTransaction} and its DTO {@link ReksadanaTransactionDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReksadanaTransactionMapper extends EntityMapper<ReksadanaTransactionDTO, ReksadanaTransaction> {



    default ReksadanaTransaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaTransaction reksadanaTransaction = new ReksadanaTransaction();
        reksadanaTransaction.setId(id);
        return reksadanaTransaction;
    }
}
