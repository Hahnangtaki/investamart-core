package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class KategoriReksadanaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(KategoriReksadanaDTO.class);
        KategoriReksadanaDTO kategoriReksadanaDTO1 = new KategoriReksadanaDTO();
        kategoriReksadanaDTO1.setId(1L);
        KategoriReksadanaDTO kategoriReksadanaDTO2 = new KategoriReksadanaDTO();
        assertThat(kategoriReksadanaDTO1).isNotEqualTo(kategoriReksadanaDTO2);
        kategoriReksadanaDTO2.setId(kategoriReksadanaDTO1.getId());
        assertThat(kategoriReksadanaDTO1).isEqualTo(kategoriReksadanaDTO2);
        kategoriReksadanaDTO2.setId(2L);
        assertThat(kategoriReksadanaDTO1).isNotEqualTo(kategoriReksadanaDTO2);
        kategoriReksadanaDTO1.setId(null);
        assertThat(kategoriReksadanaDTO1).isNotEqualTo(kategoriReksadanaDTO2);
    }
}
