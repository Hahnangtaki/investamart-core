package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class AccountReksadanaDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AccountReksadanaDTO.class);
        AccountReksadanaDTO accountReksadanaDTO1 = new AccountReksadanaDTO();
        accountReksadanaDTO1.setId(1L);
        AccountReksadanaDTO accountReksadanaDTO2 = new AccountReksadanaDTO();
        assertThat(accountReksadanaDTO1).isNotEqualTo(accountReksadanaDTO2);
        accountReksadanaDTO2.setId(accountReksadanaDTO1.getId());
        assertThat(accountReksadanaDTO1).isEqualTo(accountReksadanaDTO2);
        accountReksadanaDTO2.setId(2L);
        assertThat(accountReksadanaDTO1).isNotEqualTo(accountReksadanaDTO2);
        accountReksadanaDTO1.setId(null);
        assertThat(accountReksadanaDTO1).isNotEqualTo(accountReksadanaDTO2);
    }
}
