package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaSwitchingDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaSwitching} and its DTO {@link ReksadanaSwitchingDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReksadanaSwitchingMapper extends EntityMapper<ReksadanaSwitchingDTO, ReksadanaSwitching> {



    default ReksadanaSwitching fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaSwitching reksadanaSwitching = new ReksadanaSwitching();
        reksadanaSwitching.setId(id);
        return reksadanaSwitching;
    }
}
