package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReksadanaAssetMapperTest {

    private ReksadanaAssetMapper reksadanaAssetMapper;

    @BeforeEach
    public void setUp() {
        reksadanaAssetMapper = new ReksadanaAssetMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(reksadanaAssetMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(reksadanaAssetMapper.fromId(null)).isNull();
    }
}
