package coordinate;

import coordinate.domain.Point;
import coordinate.domain.Rectangle;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotRectangleException;
import coordinate.exception.InputNotSquareException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RectangleTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:1,3:1,4:1,5",
            "2,1:3,1:4,1:5,1"
    }, delimiter = ':')
    @DisplayName("네 점이 동일 선상에 있는 경우")
    void not_square(String point1, String point2, String point3, String point4) throws InputIndexOutNumberException {
        List<Point> rectanglePoints = Arrays.asList(
                new Point(point1),
                new Point(point2),
                new Point(point3),
                new Point(point4)
        );

        assertThatThrownBy(() -> new Rectangle(rectanglePoints)).isInstanceOf(InputNotSquareException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3,4:5,4:5,5"}, delimiter = ':')
    @DisplayName("직사각형, 정사각형이 아닌 경우")
    void not_rectangle(String point1, String point2, String point3, String point4) throws InputIndexOutNumberException {
        List<Point> rectanglePoints = Arrays.asList(
                new Point(point1),
                new Point(point2),
                new Point(point3),
                new Point(point4)
        );

        assertThatThrownBy(() -> new Rectangle(rectanglePoints))
                .isInstanceOf(InputNotRectangleException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1:1,2:2,2:2,1:1"}, delimiter = ':')
    @DisplayName("정사각형 면적 구하기")
    void perfect_square_area(String point1, String point2, String point3, String point4, int expected) throws InputIndexOutNumberException {
        List<Point> rectanglePoints = Arrays.asList(
                new Point(point1),
                new Point(point2),
                new Point(point3),
                new Point(point4)
        );

        assertThat(Math.round(new Rectangle(rectanglePoints).getArea()))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,10:22,10:22,18:10,18:96"}, delimiter = ':')
    @DisplayName("직사각형 면적 구하기")
    void rectangle_area(String point1, String point2, String point3, String point4, int expected) throws InputIndexOutNumberException {
        List<Point> rectanglePoints = Arrays.asList(
                new Point(point1),
                new Point(point2),
                new Point(point3),
                new Point(point4)
        );

        assertThat(Math.round(new Rectangle(rectanglePoints).getArea()))
                .isEqualTo(expected);
    }
}
