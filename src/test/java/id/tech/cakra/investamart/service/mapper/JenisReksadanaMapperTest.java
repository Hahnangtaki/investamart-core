package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class JenisReksadanaMapperTest {

    private JenisReksadanaMapper jenisReksadanaMapper;

    @BeforeEach
    public void setUp() {
        jenisReksadanaMapper = new JenisReksadanaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(jenisReksadanaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(jenisReksadanaMapper.fromId(null)).isNull();
    }
}
