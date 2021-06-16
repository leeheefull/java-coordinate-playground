package rentCompanyTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RentCompanyTest {
    private RentCompany company;

    @BeforeEach
    void setUp() {
        company = new RentCompany();
    }

    @Test
    @DisplayName("보고서가 일치 하는지")
    void equal_report() {
        // given
        company.addReport("Sonata", 150);
        company.addReport("K5", 260);
        company.addReport("Sonata", 120);
        company.addReport("Avante", 300);
        company.addReport("K5", 390);

        // when
        String report = company.getReports();

        // then
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + "\n" +
                        "K5 : 20리터" + "\n" +
                        "Sonata : 12리터" + "\n" +
                        "Avante : 20리터" + "\n" +
                        "K5 : 30리터"
        );
    }
}
