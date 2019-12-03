package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ReksadanaTransactionMapperTest {

    private ReksadanaTransactionMapper reksadanaTransactionMapper;

    @BeforeEach
    public void setUp() {
        reksadanaTransactionMapper = new ReksadanaTransactionMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(reksadanaTransactionMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(reksadanaTransactionMapper.fromId(null)).isNull();
    }
}
