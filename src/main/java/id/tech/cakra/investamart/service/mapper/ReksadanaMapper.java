package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Reksadana} and its DTO {@link ReksadanaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReksadanaMapper extends EntityMapper<ReksadanaDTO, Reksadana> {



    default Reksadana fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reksadana reksadana = new Reksadana();
        reksadana.setId(id);
        return reksadana;
    }
}
