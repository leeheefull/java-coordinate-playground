package coordinate;

import coordinate.domain.Line;
import coordinate.exception.InputNotLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @CsvSource(value = {"(1,2)-(3,4):(1,2):(3,4)"}, delimiter = ':')
    @DisplayName("선이 잘 저장되는지")
    void save_line(String lineInfo, String point1, String point2) {
        assertThat(new Line(lineInfo).getPoints().get(0).toString()).isEqualTo(point1);
        assertThat(new Line(lineInfo).getPoints().get(1).toString()).isEqualTo(point2);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(1,2)~(3,4)",
            "(1,2)=(3,4)",
            "(1,2)+(3,4)"
    })
    @DisplayName("선이 아닌 것이 입력될 경우")
    void not_line(String lineInfo) {
        assertThatThrownBy(() -> new Line(lineInfo)).isInstanceOf(InputNotLineException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"(7,15)-(19,10):13.0"}, delimiter = ':')
    @DisplayName("선의 길이를 구하시오")
    void get_line_length(String lineInfo, double expected) {
        assertThat(new Line(lineInfo).getLength()).isEqualTo(expected);
    }
}
