package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class JenisReksadanaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(JenisReksadanaDTO.class);
        JenisReksadanaDTO jenisReksadanaDTO1 = new JenisReksadanaDTO();
        jenisReksadanaDTO1.setId(1L);
        JenisReksadanaDTO jenisReksadanaDTO2 = new JenisReksadanaDTO();
        assertThat(jenisReksadanaDTO1).isNotEqualTo(jenisReksadanaDTO2);
        jenisReksadanaDTO2.setId(jenisReksadanaDTO1.getId());
        assertThat(jenisReksadanaDTO1).isEqualTo(jenisReksadanaDTO2);
        jenisReksadanaDTO2.setId(2L);
        assertThat(jenisReksadanaDTO1).isNotEqualTo(jenisReksadanaDTO2);
        jenisReksadanaDTO1.setId(null);
        assertThat(jenisReksadanaDTO1).isNotEqualTo(jenisReksadanaDTO2);
    }
}
