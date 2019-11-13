package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class KategoriReksadanaMapperTest {

    private KategoriReksadanaMapper kategoriReksadanaMapper;

    @BeforeEach
    public void setUp() {
        kategoriReksadanaMapper = new KategoriReksadanaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(kategoriReksadanaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(kategoriReksadanaMapper.fromId(null)).isNull();
    }
}
