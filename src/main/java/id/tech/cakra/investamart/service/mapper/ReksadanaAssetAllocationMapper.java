package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetAllocationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaAssetAllocation} and its DTO {@link ReksadanaAssetAllocationDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ReksadanaAssetAllocationMapper extends EntityMapper<ReksadanaAssetAllocationDTO, ReksadanaAssetAllocation> {



    default ReksadanaAssetAllocation fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaAssetAllocation reksadanaAssetAllocation = new ReksadanaAssetAllocation();
        reksadanaAssetAllocation.setId(id);
        return reksadanaAssetAllocation;
    }
}
