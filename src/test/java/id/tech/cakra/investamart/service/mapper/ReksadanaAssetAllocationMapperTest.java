package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReksadanaAssetAllocationMapperTest {

    private ReksadanaAssetAllocationMapper reksadanaAssetAllocationMapper;

    @BeforeEach
    public void setUp() {
        reksadanaAssetAllocationMapper = new ReksadanaAssetAllocationMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(reksadanaAssetAllocationMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(reksadanaAssetAllocationMapper.fromId(null)).isNull();
    }
}
