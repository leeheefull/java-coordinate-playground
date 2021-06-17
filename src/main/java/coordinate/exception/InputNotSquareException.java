package coordinate.exception;

import java.util.InputMismatchException;

public class InputNotSquareException extends InputMismatchException {
    public InputNotSquareException() {
        super("사각형이 아닙니다.");
    }
}
