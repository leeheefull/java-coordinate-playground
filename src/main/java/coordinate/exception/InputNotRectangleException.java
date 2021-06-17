package coordinate.exception;

import java.util.InputMismatchException;

public class InputNotRectangleException extends InputMismatchException {
    public InputNotRectangleException() {
        super("직사각형이 아닙니다.");
    }
}
