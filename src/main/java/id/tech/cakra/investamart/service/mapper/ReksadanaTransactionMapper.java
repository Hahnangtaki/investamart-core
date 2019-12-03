package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaTransactionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaTransaction} and its DTO {@link ReksadanaTransactionDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReksadanaSwitchingMapper.class, ReksadanaMapper.class})
public interface ReksadanaTransactionMapper extends EntityMapper<ReksadanaTransactionDTO, ReksadanaTransaction> {

    @Mapping(source = "buyOrder.id", target = "buyOrderId")
    @Mapping(source = "sellOrder.id", target = "sellOrderId")
    @Mapping(source = "reksadana.id", target = "reksadanaId")
    @Mapping(source = "switching.id", target = "switchingId")
    ReksadanaTransactionDTO toDto(ReksadanaTransaction reksadanaTransaction);

    @Mapping(source = "buyOrderId", target = "buyOrder")
    @Mapping(source = "sellOrderId", target = "sellOrder")
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
