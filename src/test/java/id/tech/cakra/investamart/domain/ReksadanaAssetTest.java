package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaAssetTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaAsset.class);
        ReksadanaAsset reksadanaAsset1 = new ReksadanaAsset();
        reksadanaAsset1.setId(1L);
        ReksadanaAsset reksadanaAsset2 = new ReksadanaAsset();
        reksadanaAsset2.setId(reksadanaAsset1.getId());
        assertThat(reksadanaAsset1).isEqualTo(reksadanaAsset2);
        reksadanaAsset2.setId(2L);
        assertThat(reksadanaAsset1).isNotEqualTo(reksadanaAsset2);
        reksadanaAsset1.setId(null);
        assertThat(reksadanaAsset1).isNotEqualTo(reksadanaAsset2);
    }
}
