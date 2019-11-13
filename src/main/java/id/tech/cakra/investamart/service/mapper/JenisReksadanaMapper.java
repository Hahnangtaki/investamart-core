package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.JenisReksadanaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link JenisReksadana} and its DTO {@link JenisReksadanaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JenisReksadanaMapper extends EntityMapper<JenisReksadanaDTO, JenisReksadana> {



    default JenisReksadana fromId(Long id) {
        if (id == null) {
            return null;
        }
        JenisReksadana jenisReksadana = new JenisReksadana();
        jenisReksadana.setId(id);
        return jenisReksadana;
    }
}
