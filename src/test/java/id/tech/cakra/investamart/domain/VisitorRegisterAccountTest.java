package id.tech.cakra.investamart.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class VisitorRegisterAccountTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(VisitorRegisterAccount.class);
        VisitorRegisterAccount visitorRegisterAccount1 = new VisitorRegisterAccount();
        visitorRegisterAccount1.setId(1L);
        VisitorRegisterAccount visitorRegisterAccount2 = new VisitorRegisterAccount();
        visitorRegisterAccount2.setId(visitorRegisterAccount1.getId());
        assertThat(visitorRegisterAccount1).isEqualTo(visitorRegisterAccount2);
        visitorRegisterAccount2.setId(2L);
        assertThat(visitorRegisterAccount1).isNotEqualTo(visitorRegisterAccount2);
        visitorRegisterAccount1.setId(null);
        assertThat(visitorRegisterAccount1).isNotEqualTo(visitorRegisterAccount2);
    }
}
