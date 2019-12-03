package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.KategoriReksadanaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link KategoriReksadana} and its DTO {@link KategoriReksadanaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface KategoriReksadanaMapper extends EntityMapper<KategoriReksadanaDTO, KategoriReksadana> {


    @Mapping(target = "reksadanas", ignore = true)
    @Mapping(target = "removeReksadana", ignore = true)
    KategoriReksadana toEntity(KategoriReksadanaDTO kategoriReksadanaDTO);

    default KategoriReksadana fromId(Long id) {
        if (id == null) {
            return null;
        }
        KategoriReksadana kategoriReksadana = new KategoriReksadana();
        kategoriReksadana.setId(id);
        return kategoriReksadana;
    }
}
