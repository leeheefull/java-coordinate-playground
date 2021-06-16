package coordinate;

import coordinate.domain.Point;
import coordinate.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {"(1,2):1:2", "(10,1):10:1"}, delimiter = ':')
    void save_point(String inputPoint, int expectedX, int expectedY) {
        // given
        Point point = new Point(inputPoint);

        // when, then
        assertThat(point.getX()).isEqualTo(expectedX);
        assertThat(point.getY()).isEqualTo(expectedY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(p,e)", "([,-)"})
    @DisplayName("숫자가 아닌 값이 입력되면 예외")
    void not_number(String input) {
        assertThatThrownBy(() -> new Point(input)).isInstanceOf(InputNotNumberException.class);
    }
}
