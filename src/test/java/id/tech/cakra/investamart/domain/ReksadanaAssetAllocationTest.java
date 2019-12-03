package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaAssetAllocationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaAssetAllocation.class);
        ReksadanaAssetAllocation reksadanaAssetAllocation1 = new ReksadanaAssetAllocation();
        reksadanaAssetAllocation1.setId(1L);
        ReksadanaAssetAllocation reksadanaAssetAllocation2 = new ReksadanaAssetAllocation();
        reksadanaAssetAllocation2.setId(reksadanaAssetAllocation1.getId());
        assertThat(reksadanaAssetAllocation1).isEqualTo(reksadanaAssetAllocation2);
        reksadanaAssetAllocation2.setId(2L);
        assertThat(reksadanaAssetAllocation1).isNotEqualTo(reksadanaAssetAllocation2);
        reksadanaAssetAllocation1.setId(null);
        assertThat(reksadanaAssetAllocation1).isNotEqualTo(reksadanaAssetAllocation2);
    }
}
