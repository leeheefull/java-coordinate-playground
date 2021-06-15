package rentCompany;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차 종류에 따라 리터당 이동거리 반환")
    void distance_per_liter() {
        assertThat(new Sonata().getDistancePerLiter()).isEqualTo(10);
        assertThat(new Avante().getDistancePerLiter()).isEqualTo(15);
        assertThat(new K5().getDistancePerLiter()).isEqualTo(13);
    }
}
