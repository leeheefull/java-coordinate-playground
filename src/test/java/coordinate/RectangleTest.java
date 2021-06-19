package coordinate;

import coordinate.domain.Rectangle;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotRectangleException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RectangleTest {
    @ParameterizedTest
    @CsvSource(value = {"(1,1)-(1,2)-(2,2)-(2,1):(1,1):(1,2):(2,2):(2,1)"}, delimiter = ':')
    @DisplayName("정사각형이 잘 저장되는지")
    void save_perfect_square(String rectangleInfo, String point1, String point2, String point3, String point4) throws InputIndexOutNumberException {
        assertThat(new Rectangle(rectangleInfo).getPoints().get(0).toString()).isEqualTo(point1);
        assertThat(new Rectangle(rectangleInfo).getPoints().get(1).toString()).isEqualTo(point2);
        assertThat(new Rectangle(rectangleInfo).getPoints().get(2).toString()).isEqualTo(point3);
        assertThat(new Rectangle(rectangleInfo).getPoints().get(3).toString()).isEqualTo(point4);
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(22,10)-(22,18)-(10,18):(10,10):(22,10):(22,18):(10,18)"}, delimiter = ':')
    @DisplayName("직사각형이 잘 저장되는지")
    void save_rectangle(String rectangleInfo, String point1, String point2, String point3, String point4) throws InputIndexOutNumberException {
        assertThat(new Rectangle(rectangleInfo).getPoints().get(0).toString()).isEqualTo(point1);
        assertThat(new Rectangle(rectangleInfo).getPoints().get(1).toString()).isEqualTo(point2);
        assertThat(new Rectangle(rectangleInfo).getPoints().get(2).toString()).isEqualTo(point3);
        assertThat(new Rectangle(rectangleInfo).getPoints().get(3).toString()).isEqualTo(point4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"(1,2)-(3,4)-(5,4)-(5,5)"})
    @DisplayName("직사각형이 아닌 경우")
    void not_rectangle(String rectangleInfo) {
        assertThatThrownBy(() -> new Rectangle(rectangleInfo))
                .isInstanceOf(InputNotRectangleException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"(1,1)-(1,2)-(2,2)-(2,1):1"}, delimiter = ':')
    @DisplayName("정사각형 면적 구하기")
    void perfect_square_area(String rectangleInfo, int expected) throws InputIndexOutNumberException {
        assertThat(Math.round(new Rectangle(rectangleInfo).getArea()))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"(10,10)-(22,10)-(22,18)-(10,18):96"}, delimiter = ':')
    @DisplayName("직사각형 면적 구하기")
    void rectangle_area(String rectangleInfo, int expected) throws InputIndexOutNumberException {
        assertThat(Math.round(new Rectangle(rectangleInfo).getArea()))
                .isEqualTo(expected);
    }
}
