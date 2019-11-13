package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaSwitchingTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaSwitching.class);
        ReksadanaSwitching reksadanaSwitching1 = new ReksadanaSwitching();
        reksadanaSwitching1.setId(1L);
        ReksadanaSwitching reksadanaSwitching2 = new ReksadanaSwitching();
        reksadanaSwitching2.setId(reksadanaSwitching1.getId());
        assertThat(reksadanaSwitching1).isEqualTo(reksadanaSwitching2);
        reksadanaSwitching2.setId(2L);
        assertThat(reksadanaSwitching1).isNotEqualTo(reksadanaSwitching2);
        reksadanaSwitching1.setId(null);
        assertThat(reksadanaSwitching1).isNotEqualTo(reksadanaSwitching2);
    }
}
