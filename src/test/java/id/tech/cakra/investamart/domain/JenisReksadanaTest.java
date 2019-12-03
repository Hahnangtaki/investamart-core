package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class JenisReksadanaTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(JenisReksadana.class);
        JenisReksadana jenisReksadana1 = new JenisReksadana();
        jenisReksadana1.setId(1L);
        JenisReksadana jenisReksadana2 = new JenisReksadana();
        jenisReksadana2.setId(jenisReksadana1.getId());
        assertThat(jenisReksadana1).isEqualTo(jenisReksadana2);
        jenisReksadana2.setId(2L);
        assertThat(jenisReksadana1).isNotEqualTo(jenisReksadana2);
        jenisReksadana1.setId(null);
        assertThat(jenisReksadana1).isNotEqualTo(jenisReksadana2);
    }
}
