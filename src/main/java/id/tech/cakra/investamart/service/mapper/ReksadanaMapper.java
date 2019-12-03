package id.tech.cakra.investamart.service.mapper;

import id.tech.cakra.investamart.domain.*;
import id.tech.cakra.investamart.service.dto.ReksadanaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Reksadana} and its DTO {@link ReksadanaDTO}.
 */
@Mapper(componentModel = "spring", uses = {JenisReksadanaMapper.class, KategoriReksadanaMapper.class})
public interface ReksadanaMapper extends EntityMapper<ReksadanaDTO, Reksadana> {

    @Mapping(source = "jenisReksadana.id", target = "jenisReksadanaId")
    @Mapping(source = "kategoriReksadana.id", target = "kategoriReksadanaId")
    ReksadanaDTO toDto(Reksadana reksadana);

    @Mapping(target = "reksadanaAssetAllocations", ignore = true)
    @Mapping(target = "removeReksadanaAssetAllocation", ignore = true)
    @Mapping(target = "reksadanaTransactions", ignore = true)
    @Mapping(target = "removeReksadanaTransaction", ignore = true)
    @Mapping(target = "reksadanaAssets", ignore = true)
    @Mapping(target = "removeReksadanaAsset", ignore = true)
    @Mapping(target = "sourceReks", ignore = true)
    @Mapping(target = "removeSourceRek", ignore = true)
    @Mapping(target = "targetReks", ignore = true)
    @Mapping(target = "removeTargetRek", ignore = true)
    @Mapping(target = "accountReksadanas", ignore = true)
    @Mapping(target = "removeAccountReksadana", ignore = true)
    @Mapping(source = "jenisReksadanaId", target = "jenisReksadana")
    @Mapping(source = "kategoriReksadanaId", target = "kategoriReksadana")
    Reksadana toEntity(ReksadanaDTO reksadanaDTO);

    default Reksadana fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reksadana reksadana = new Reksadana();
        reksadana.setId(id);
        return reksadana;
    }
}
