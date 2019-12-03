package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class AccountReksadanaMapperTest {

    private AccountReksadanaMapper accountReksadanaMapper;

    @BeforeEach
    public void setUp() {
        accountReksadanaMapper = new AccountReksadanaMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(accountReksadanaMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(accountReksadanaMapper.fromId(null)).isNull();
    }
}
