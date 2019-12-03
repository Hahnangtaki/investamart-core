package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class AccountReksadanaTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AccountReksadana.class);
        AccountReksadana accountReksadana1 = new AccountReksadana();
        accountReksadana1.setId(1L);
        AccountReksadana accountReksadana2 = new AccountReksadana();
        accountReksadana2.setId(accountReksadana1.getId());
        assertThat(accountReksadana1).isEqualTo(accountReksadana2);
        accountReksadana2.setId(2L);
        assertThat(accountReksadana1).isNotEqualTo(accountReksadana2);
        accountReksadana1.setId(null);
        assertThat(accountReksadana1).isNotEqualTo(accountReksadana2);
    }
}
