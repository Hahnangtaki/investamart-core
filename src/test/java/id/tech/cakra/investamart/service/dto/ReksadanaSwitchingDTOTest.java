package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaSwitchingDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaSwitchingDTO.class);
        ReksadanaSwitchingDTO reksadanaSwitchingDTO1 = new ReksadanaSwitchingDTO();
        reksadanaSwitchingDTO1.setId(1L);
        ReksadanaSwitchingDTO reksadanaSwitchingDTO2 = new ReksadanaSwitchingDTO();
        assertThat(reksadanaSwitchingDTO1).isNotEqualTo(reksadanaSwitchingDTO2);
        reksadanaSwitchingDTO2.setId(reksadanaSwitchingDTO1.getId());
        assertThat(reksadanaSwitchingDTO1).isEqualTo(reksadanaSwitchingDTO2);
        reksadanaSwitchingDTO2.setId(2L);
        assertThat(reksadanaSwitchingDTO1).isNotEqualTo(reksadanaSwitchingDTO2);
        reksadanaSwitchingDTO1.setId(null);
        assertThat(reksadanaSwitchingDTO1).isNotEqualTo(reksadanaSwitchingDTO2);
    }
}
