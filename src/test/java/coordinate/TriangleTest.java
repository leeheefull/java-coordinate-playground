package coordinate;

import coordinate.domain.Triangle;
import coordinate.exception.InputNotTriangleException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TriangleTest {
    @ParameterizedTest
    @CsvSource(value = {"(1,2)-(3,4)-(5,4):(1,2):(3,4):(5,4)"}, delimiter = ':')
    @DisplayName("삼각형이 잘 저장되는지")
    void save_triangle(String triangleInfo, String point1, String point2, String point3) {
        assertThat(new Triangle(triangleInfo).getPoints().get(0).toString()).isEqualTo(point1);
        assertThat(new Triangle(triangleInfo).getPoints().get(1).toString()).isEqualTo(point2);
        assertThat(new Triangle(triangleInfo).getPoints().get(2).toString()).isEqualTo(point3);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(1,2)-(3,4)",
            "(1,2)-(3,4)-(5,3)-(2,1)",
            "(1,2)-(3,4)-(5,4)-(2,1)-(10,10)"
    })
    @DisplayName("삼각형이 아닌 경우")
    void not_triangle(String triangleInfo) {
        assertThatThrownBy(() -> new Triangle(triangleInfo)).isInstanceOf(InputNotTriangleException.class);
    }
}
