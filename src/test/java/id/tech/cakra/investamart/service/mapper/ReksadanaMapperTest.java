package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReksadanaMapperTest {

    private ReksadanaMapper reksadanaMapper;

    @BeforeEach
    public void setUp() {
        reksadanaMapper = new ReksadanaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(reksadanaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(reksadanaMapper.fromId(null)).isNull();
    }
}
