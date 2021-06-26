package coordinate;

import coordinate.domain.Point;
import coordinate.domain.Triangle;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotTriangleException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class TriangleTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:1,3:1,4",
            "2,1:3,1:4,1"
    }, delimiter = ':')
    @DisplayName("세 점이 동일 선에 존재할 경우")
    void not_triangle(String point1, String point2, String point3) throws InputIndexOutNumberException {
        List<Point> trianglePoints = Arrays.asList(
                new Point(point1),
                new Point(point2),
                new Point(point3)
        );

        assertThatThrownBy(() -> new Triangle(trianglePoints))
                .isInstanceOf(InputNotTriangleException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10,10:14,15:20,8:29"}, delimiter = ':')
    @DisplayName("삼각형 면적 구하기")
    void triangle_area(String point1, String point2, String point3, int expected) throws InputIndexOutNumberException {
        List<Point> trianglePoints = Arrays.asList(
                new Point(point1),
                new Point(point2),
                new Point(point3)
        );

        assertThat(Math.round(new Triangle(trianglePoints).getArea()))
                .isEqualTo(expected);
    }
}
