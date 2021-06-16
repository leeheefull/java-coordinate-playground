package coordinate;

import coordinate.domain.Number;
import coordinate.domain.Point;
import coordinate.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("숫자가 저장되는지")
    void save_number() {
        assertThat(new Number("8").getNumber()).isEqualTo(8);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력될 경우")
    void not_number() {
        assertThatThrownBy(() -> new Number("p")).isInstanceOf(InputNotNumberException.class);
    }
}
