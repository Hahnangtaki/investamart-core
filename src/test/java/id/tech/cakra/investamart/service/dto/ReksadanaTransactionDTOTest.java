package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class ReksadanaTransactionDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReksadanaTransactionDTO.class);
        ReksadanaTransactionDTO reksadanaTransactionDTO1 = new ReksadanaTransactionDTO();
        reksadanaTransactionDTO1.setId(1L);
        ReksadanaTransactionDTO reksadanaTransactionDTO2 = new ReksadanaTransactionDTO();
        assertThat(reksadanaTransactionDTO1).isNotEqualTo(reksadanaTransactionDTO2);
        reksadanaTransactionDTO2.setId(reksadanaTransactionDTO1.getId());
        assertThat(reksadanaTransactionDTO1).isEqualTo(reksadanaTransactionDTO2);
        reksadanaTransactionDTO2.setId(2L);
        assertThat(reksadanaTransactionDTO1).isNotEqualTo(reksadanaTransactionDTO2);
        reksadanaTransactionDTO1.setId(null);
        assertThat(reksadanaTransactionDTO1).isNotEqualTo(reksadanaTransactionDTO2);
    }
}
