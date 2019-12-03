package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaSwitching} and its DTO {@link ReksadanaSwitchingDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReksadanaMapper.class})
public interface ReksadanaSwitchingMapper extends EntityMapper<ReksadanaSwitchingDTO, ReksadanaSwitching> {

    @Mapping(source = "source.id", target = "sourceId")
    @Mapping(source = "target.id", target = "targetId")
    ReksadanaSwitchingDTO toDto(ReksadanaSwitching reksadanaSwitching);

    @Mapping(target = "switchingOrders", ignore = true)
    @Mapping(target = "removeSwitchingOrder", ignore = true)
    @Mapping(target = "buy", ignore = true)
    @Mapping(target = "sell", ignore = true)
    @Mapping(source = "sourceId", target = "source")
    @Mapping(source = "targetId", target = "target")
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
