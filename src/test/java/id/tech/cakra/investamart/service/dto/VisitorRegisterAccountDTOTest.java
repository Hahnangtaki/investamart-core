package id.tech.cakra.investamart.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import id.tech.cakra.investamart.web.rest.TestUtil;

public class VisitorRegisterAccountDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VisitorRegisterAccountDTO.class);
        VisitorRegisterAccountDTO visitorRegisterAccountDTO1 = new VisitorRegisterAccountDTO();
        visitorRegisterAccountDTO1.setId(1L);
        VisitorRegisterAccountDTO visitorRegisterAccountDTO2 = new VisitorRegisterAccountDTO();
        assertThat(visitorRegisterAccountDTO1).isNotEqualTo(visitorRegisterAccountDTO2);
        visitorRegisterAccountDTO2.setId(visitorRegisterAccountDTO1.getId());
        assertThat(visitorRegisterAccountDTO1).isEqualTo(visitorRegisterAccountDTO2);
        visitorRegisterAccountDTO2.setId(2L);
        assertThat(visitorRegisterAccountDTO1).isNotEqualTo(visitorRegisterAccountDTO2);
        visitorRegisterAccountDTO1.setId(null);
        assertThat(visitorRegisterAccountDTO1).isNotEqualTo(visitorRegisterAccountDTO2);
    }
}
