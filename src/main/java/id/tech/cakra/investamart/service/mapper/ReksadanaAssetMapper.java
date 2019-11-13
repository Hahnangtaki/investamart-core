package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaAsset} and its DTO {@link ReksadanaAssetDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReksadanaAssetMapper extends EntityMapper<ReksadanaAssetDTO, ReksadanaAsset> {



    default ReksadanaAsset fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaAsset reksadanaAsset = new ReksadanaAsset();
        reksadanaAsset.setId(id);
        return reksadanaAsset;
    }
}
