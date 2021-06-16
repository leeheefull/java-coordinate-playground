package rentCompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    @DisplayName("잘 저장 되는지")
    void add_car() {
        // given
        cars.addCar("Sonata", 100);
        cars.addCar("Avante", 150);
        cars.addCar("K5", 130);

        // when, then
        assertThat(cars.getCarNames()).isEqualTo(Arrays.asList("Sonata", "Avante", "K5"));
        assertThat(cars.getCarDistances()).isEqualTo(Arrays.asList(100, 150, 130));
    }
}
