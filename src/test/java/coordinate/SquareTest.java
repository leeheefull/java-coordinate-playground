package coordinate;

import coordinate.domain.Rectangle;
import coordinate.domain.Square;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotSquareException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class SquareTest {
    @ParameterizedTest
    @CsvSource(value = {"(1,2)-(3,4)-(5,4)-(5,5):(1,2):(3,4):(5,4):(5,5)"}, delimiter = ':')
    @DisplayName("사각형이 잘 저장되는지")
    void save_square(String squareInfo, String point1, String point2, String point3, String point4) throws InputIndexOutNumberException {
        assertThat(new Square(squareInfo).getPoints().get(0).toString()).isEqualTo(point1);
        assertThat(new Square(squareInfo).getPoints().get(1).toString()).isEqualTo(point2);
        assertThat(new Square(squareInfo).getPoints().get(2).toString()).isEqualTo(point3);
        assertThat(new Square(squareInfo).getPoints().get(3).toString()).isEqualTo(point4);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(1,2)-(3,4)",
            "(1,2)-(3,4)-(5,3)",
            "(1,2)-(3,4)-(5,4)-(2,1)-(10,10)"
    })
    @DisplayName("사각형이 아닌 경우")
    void not_square(String squareInfo) {
        assertThatThrownBy(() -> new Square(squareInfo)).isInstanceOf(InputNotSquareException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(22,10)-(22,18)-(10,18):96"}, delimiter = ':')
    @DisplayName("직사각형 면적 구하기")
    void rectangle_area(String rectangleInfo, int expected) throws InputIndexOutNumberException {
        assertThat(Math.round(new Rectangle(rectangleInfo).getArea())).isEqualTo(expected);
    }
}
