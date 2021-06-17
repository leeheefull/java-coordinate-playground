package coordinate.exception;

import java.util.InputMismatchException;

public class InputNotTriangleException extends InputMismatchException {
    public InputNotTriangleException() {
        super("삼각형이 아닙니다.");
    }
}
