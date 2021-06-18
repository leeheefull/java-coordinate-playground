package coordinate;

import coordinate.domain.Number;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("숫자가 저장되는지")
    void save_number() throws InputIndexOutNumberException {
        assertThat(new Number("8").getNumber()).isEqualTo(8);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 입력될 경우")
    void not_number() {
        assertThatThrownBy(() -> new Number("p")).isInstanceOf(InputNotNumberException.class);
    }

    @Test
    @DisplayName("숫자가 1보다 작거나 24보다 큰 경우")
    void over_number() {
        assertThatThrownBy(() -> new Number("25")).isInstanceOf(InputIndexOutNumberException.class);
        assertThatThrownBy(() -> new Number("0")).isInstanceOf(InputIndexOutNumberException.class);
    }
}
