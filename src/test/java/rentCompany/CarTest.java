package rentCompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Sonata sonata;
    private Avante avante;
    private K5 k5;

    @BeforeEach
    void setUp() {
        this.sonata = new Sonata(100);
        this.avante = new Avante(150);
        this.k5 = new K5(130);
    }

    @Test
    @DisplayName("자동차 종류에 따라 리터당 이동거리 반환")
    void distance_per_liter() {
        assertThat(sonata.getDistancePerLiter()).isEqualTo(10);
        assertThat(avante.getDistancePerLiter()).isEqualTo(15);
        assertThat(k5.getDistancePerLiter()).isEqualTo(13);
    }

    @Test
    @DisplayName("사용자가 입력한 자동차 이동거리 반환")
    void trip_distance() {
        assertThat(sonata.getTripDistance()).isEqualTo(100);
        assertThat(avante.getTripDistance()).isEqualTo(150);
        assertThat(k5.getTripDistance()).isEqualTo(130);
    }

    @Test
    @DisplayName("자동차의 이름 반환")
    void car_name() {
        assertThat(sonata.getName()).isEqualTo("Sonata");
        assertThat(avante.getName()).isEqualTo("Avante");
        assertThat(k5.getName()).isEqualTo("K5");
    }

    @Test
    @DisplayName("연비와 이동거리를 통해서 주입해야할 연료량 바환")
    void need_fuel() {
        assertThat(sonata.getChargeQuantity()).isEqualTo(10);
        assertThat(avante.getChargeQuantity()).isEqualTo(10);
        assertThat(k5.getChargeQuantity()).isEqualTo(10);
    }
}
