package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaAssetDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaAssetDTO.class);
        ReksadanaAssetDTO reksadanaAssetDTO1 = new ReksadanaAssetDTO();
        reksadanaAssetDTO1.setId(1L);
        ReksadanaAssetDTO reksadanaAssetDTO2 = new ReksadanaAssetDTO();
        assertThat(reksadanaAssetDTO1).isNotEqualTo(reksadanaAssetDTO2);
        reksadanaAssetDTO2.setId(reksadanaAssetDTO1.getId());
        assertThat(reksadanaAssetDTO1).isEqualTo(reksadanaAssetDTO2);
        reksadanaAssetDTO2.setId(2L);
        assertThat(reksadanaAssetDTO1).isNotEqualTo(reksadanaAssetDTO2);
        reksadanaAssetDTO1.setId(null);
        assertThat(reksadanaAssetDTO1).isNotEqualTo(reksadanaAssetDTO2);
    }
}
