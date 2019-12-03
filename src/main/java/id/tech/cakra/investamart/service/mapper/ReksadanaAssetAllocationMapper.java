package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaAssetAllocationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReksadanaAssetAllocation} and its DTO {@link ReksadanaAssetAllocationDTO}.
 */
@Mapper(componentModel = "spring", uses = {ReksadanaMapper.class})
public interface ReksadanaAssetAllocationMapper extends EntityMapper<ReksadanaAssetAllocationDTO, ReksadanaAssetAllocation> {

    @Mapping(source = "reksadana.id", target = "reksadanaId")
    ReksadanaAssetAllocationDTO toDto(ReksadanaAssetAllocation reksadanaAssetAllocation);

    @Mapping(source = "reksadanaId", target = "reksadana")
    ReksadanaAssetAllocation toEntity(ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO);

    default ReksadanaAssetAllocation fromId(Long id) {
        if (id == null) {
            return null;
        }
        ReksadanaAssetAllocation reksadanaAssetAllocation = new ReksadanaAssetAllocation();
        reksadanaAssetAllocation.setId(id);
        return reksadanaAssetAllocation;
    }
}
