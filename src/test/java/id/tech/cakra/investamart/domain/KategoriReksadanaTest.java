package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class KategoriReksadanaTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(KategoriReksadana.class);
        KategoriReksadana kategoriReksadana1 = new KategoriReksadana();
        kategoriReksadana1.setId(1L);
        KategoriReksadana kategoriReksadana2 = new KategoriReksadana();
        kategoriReksadana2.setId(kategoriReksadana1.getId());
        assertThat(kategoriReksadana1).isEqualTo(kategoriReksadana2);
        kategoriReksadana2.setId(2L);
        assertThat(kategoriReksadana1).isNotEqualTo(kategoriReksadana2);
        kategoriReksadana1.setId(null);
        assertThat(kategoriReksadana1).isNotEqualTo(kategoriReksadana2);
    }
}
