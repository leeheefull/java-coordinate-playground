package coordinate;

import coordinate.domain.Line;
import coordinate.domain.Point;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2:1,2"}, delimiter = ':')
    @DisplayName("점이 같을 때")
    void equal_points(String point1, String point2) throws InputIndexOutNumberException {
        List<Point> linePoints = Arrays.asList(
                new Point(point1),
                new Point(point2)
        );

        assertThatThrownBy(() -> new Line(linePoints)).isInstanceOf(InputNotLineException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"7,15:19,10:13"}, delimiter = ':')
    @DisplayName("선의 길이를 구하시오")
    void get_line_length(String point1, String point2, int expected) throws InputIndexOutNumberException {
        List<Point> linePoints = Arrays.asList(
                new Point(point1),
                new Point(point2)
        );

        assertThat(Math.round(new Line(linePoints).getArea())).isEqualTo(expected);
    }
}
