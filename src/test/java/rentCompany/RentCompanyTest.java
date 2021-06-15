package rentCompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RentCompanyTest {
    private RentCompany company;

    @BeforeEach
    void setUp() {
        company = RentCompany.create();
    }

    @Test
    @DisplayName("보고서가 일치 하는지")
    void equal_report() {
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + "\n" +
                        "K5 : 20리터" + "\n" +
                        "Sonata : 12리터" + "\n" +
                        "Avante : 20리터" + "\n" +
                        "K5 : 30리터"
        );
    }
}
