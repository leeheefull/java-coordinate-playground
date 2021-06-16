package coordinateTest;

import coordinate.domain.Point;
import coordinate.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {"p,e", "[,-"})
    @DisplayName("숫자가 아닌 값이 입력되면 예외")
    void not_number(String x, String y) {
        assertThatThrownBy(() -> new Point(x, y)).isInstanceOf(InputNotNumberException.class);
    }
}
