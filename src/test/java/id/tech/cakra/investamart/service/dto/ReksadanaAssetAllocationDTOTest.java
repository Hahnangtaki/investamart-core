package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaAssetAllocationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaAssetAllocationDTO.class);
        ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO1 = new ReksadanaAssetAllocationDTO();
        reksadanaAssetAllocationDTO1.setId(1L);
        ReksadanaAssetAllocationDTO reksadanaAssetAllocationDTO2 = new ReksadanaAssetAllocationDTO();
        assertThat(reksadanaAssetAllocationDTO1).isNotEqualTo(reksadanaAssetAllocationDTO2);
        reksadanaAssetAllocationDTO2.setId(reksadanaAssetAllocationDTO1.getId());
        assertThat(reksadanaAssetAllocationDTO1).isEqualTo(reksadanaAssetAllocationDTO2);
        reksadanaAssetAllocationDTO2.setId(2L);
        assertThat(reksadanaAssetAllocationDTO1).isNotEqualTo(reksadanaAssetAllocationDTO2);
        reksadanaAssetAllocationDTO1.setId(null);
        assertThat(reksadanaAssetAllocationDTO1).isNotEqualTo(reksadanaAssetAllocationDTO2);
    }
}
