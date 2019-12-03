package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaSwitching} and its DTO {@link ReksadanaSwitchingDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReksadanaTransactionMapper.class, ReksadanaMapper.class})
public interface ReksadanaSwitchingMapper extends EntityMapper<ReksadanaSwitchingDTO, ReksadanaSwitching> {

    @Mapping(source = "orderBuy.id", target = "orderBuyId")
    @Mapping(source = "orderSell.id", target = "orderSellId")
    @Mapping(source = "reksaSource.id", target = "reksaSourceId")
    @Mapping(source = "reksaTarget.id", target = "reksaTargetId")
    ReksadanaSwitchingDTO toDto(ReksadanaSwitching reksadanaSwitching);

    @Mapping(source = "orderBuyId", target = "orderBuy")
    @Mapping(source = "orderSellId", target = "orderSell")
    @Mapping(target = "switchingOrders", ignore = true)
    @Mapping(target = "removeSwitchingOrder", ignore = true)
    @Mapping(source = "reksaSourceId", target = "reksaSource")
    @Mapping(source = "reksaTargetId", target = "reksaTarget")
    ReksadanaSwitching toEntity(ReksadanaSwitchingDTO reksadanaSwitchingDTO);

    default ReksadanaSwitching fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaSwitching reksadanaSwitching = new ReksadanaSwitching();
        reksadanaSwitching.setId(id);
        return reksadanaSwitching;
    }
}
