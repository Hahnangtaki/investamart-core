package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Reksadana.class);
        Reksadana reksadana1 = new Reksadana();
        reksadana1.setId(1L);
        Reksadana reksadana2 = new Reksadana();
        reksadana2.setId(reksadana1.getId());
        assertThat(reksadana1).isEqualTo(reksadana2);
        reksadana2.setId(2L);
        assertThat(reksadana1).isNotEqualTo(reksadana2);
        reksadana1.setId(null);
        assertThat(reksadana1).isNotEqualTo(reksadana2);
    }
}
