package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaDTO.class);
        ReksadanaDTO reksadanaDTO1 = new ReksadanaDTO();
        reksadanaDTO1.setId(1L);
        ReksadanaDTO reksadanaDTO2 = new ReksadanaDTO();
        assertThat(reksadanaDTO1).isNotEqualTo(reksadanaDTO2);
        reksadanaDTO2.setId(reksadanaDTO1.getId());
        assertThat(reksadanaDTO1).isEqualTo(reksadanaDTO2);
        reksadanaDTO2.setId(2L);
        assertThat(reksadanaDTO1).isNotEqualTo(reksadanaDTO2);
        reksadanaDTO1.setId(null);
        assertThat(reksadanaDTO1).isNotEqualTo(reksadanaDTO2);
    }
}
