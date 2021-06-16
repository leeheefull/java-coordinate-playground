package rentCompanyTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {
            "Sonata:10",
            "Avante:15",
            "K5:13"
    }, delimiter = ':')
    @DisplayName("자동차 종류에 따라 리터당 이동거리 반환")
    void fuel_efficiency(String actual, int expected) {
        assertThat(Car.of(actual).getFuelEfficiency()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Sonata:Sonata",
            "Avante:Avante",
            "K5:K5"
    }, delimiter = ':')
    @DisplayName("자동차의 이름 반환")
    void name(String actual, String expected) {
        assertThat(Car.of(actual).getName()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Sonata:100:10",
            "Avante:150:10",
            "K5:130:10"
    }, delimiter = ':')
    @DisplayName("연비와 이동거리를 통해서 주입해야할 연료량 반환")
    void charge_quantity(String name, int distance, int expected) {
        assertThat(Car.of(name).getChargeQuantity(distance)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Sonata,150,Sonata : 15리터",
            "K5,260,K5 : 20리터",
            "Sonata,120,Sonata : 12리터",
            "Avante,300,Avante : 20리터",
            "K5,390,K5 : 30리터",
    }, delimiter = ',')
    @DisplayName("보고서 한 줄이 입력한 값과 일치하는지")
    void print(String name, int distance, String expected) {
        assertThat(Car.of(name).print(distance)).isEqualTo(expected);
    }
}
