package coordinate;

import coordinate.domain.Number;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "24"})
    @DisplayName("숫자가 저장되는지")
    void save_number(String numberInfo) throws InputIndexOutNumberException {
        assertThat(new Number(numberInfo).getNumber())
                .isEqualTo(Integer.parseInt(numberInfo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"p", "[]"})
    @DisplayName("숫자가 아닌 값이 입력될 경우")
    void not_number(String numberInfo) {
        assertThatThrownBy(() -> new Number(numberInfo))
                .isInstanceOf(InputNotNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "25"})
    @DisplayName("숫자가 1보다 작거나 24보다 큰 경우")
    void over_number(String numberInfo) {
        assertThatThrownBy(() -> new Number(numberInfo))
                .isInstanceOf(InputIndexOutNumberException.class);
    }
}
