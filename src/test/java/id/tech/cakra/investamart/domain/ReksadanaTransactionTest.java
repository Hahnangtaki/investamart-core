package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaTransactionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaTransaction.class);
        ReksadanaTransaction reksadanaTransaction1 = new ReksadanaTransaction();
        reksadanaTransaction1.setId(1L);
        ReksadanaTransaction reksadanaTransaction2 = new ReksadanaTransaction();
        reksadanaTransaction2.setId(reksadanaTransaction1.getId());
        assertThat(reksadanaTransaction1).isEqualTo(reksadanaTransaction2);
        reksadanaTransaction2.setId(2L);
        assertThat(reksadanaTransaction1).isNotEqualTo(reksadanaTransaction2);
        reksadanaTransaction1.setId(null);
        assertThat(reksadanaTransaction1).isNotEqualTo(reksadanaTransaction2);
    }
}
