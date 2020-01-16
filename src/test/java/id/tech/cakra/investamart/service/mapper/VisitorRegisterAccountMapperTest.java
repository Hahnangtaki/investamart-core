package id.tech.cakra.investamart.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class VisitorRegisterAccountMapperTest {

    private VisitorRegisterAccountMapper visitorRegisterAccountMapper;

    @BeforeEach
    public void setUp() {
        visitorRegisterAccountMapper = new VisitorRegisterAccountMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(visitorRegisterAccountMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(visitorRegisterAccountMapper.fromId(null)).isNull();
    }
}
