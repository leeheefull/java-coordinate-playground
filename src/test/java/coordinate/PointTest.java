package coordinate;

import coordinate.domain.Point;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotPointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PointTest {
    @ParameterizedTest
    @CsvSource(value = {"(1,2):1:2", "(10,1):10:1"}, delimiter = ':')
    @DisplayName("점이 잘 저장 되는지")
    void save_point(String pointInfo, int expectedX, int expectedY) throws InputIndexOutNumberException {
        // given
        Point point = new Point(pointInfo);

        // when, then
        assertThat(point.getX().getNumber()).isEqualTo(expectedX);
        assertThat(point.getY().getNumber()).isEqualTo(expectedY);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[1,2]", "(3/4)"})
    @DisplayName("점이 아닌 것이 입력될 경우")
    void not_point(String pointInfo) {
        assertThatThrownBy(() -> new Point(pointInfo)).isInstanceOf(InputNotPointException.class);
    }
}
