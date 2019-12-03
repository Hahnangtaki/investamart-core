package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReksadanaSwitchingMapperTest {

    private ReksadanaSwitchingMapper reksadanaSwitchingMapper;

    @BeforeEach
    public void setUp() {
        reksadanaSwitchingMapper = new ReksadanaSwitchingMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(reksadanaSwitchingMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(reksadanaSwitchingMapper.fromId(null)).isNull();
    }
}
