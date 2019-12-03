package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaTransaction} and its DTO {@link ReksadanaTransactionDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReksadanaMapper.class, ReksadanaSwitchingMapper.class})
public interface ReksadanaTransactionMapper extends EntityMapper<ReksadanaTransactionDTO, ReksadanaTransaction> {

    @Mapping(source = "reksadana.id", target = "reksadanaId")
    @Mapping(source = "switching.id", target = "switchingId")
    ReksadanaTransactionDTO toDto(ReksadanaTransaction reksadanaTransaction);

    @Mapping(target = "buy", ignore = true)
    @Mapping(target = "sell", ignore = true)
    @Mapping(source = "reksadanaId", target = "reksadana")
    @Mapping(source = "switchingId", target = "switching")
    ReksadanaTransaction toEntity(ReksadanaTransactionDTO reksadanaTransactionDTO);

    default ReksadanaTransaction fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaTransaction reksadanaTransaction = new ReksadanaTransaction();
        reksadanaTransaction.setId(id);
        return reksadanaTransaction;
    }
}
