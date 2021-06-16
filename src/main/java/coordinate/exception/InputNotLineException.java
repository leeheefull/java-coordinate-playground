package coordinate.exception;

import java.util.InputMismatchException;

public class InputNotLineException extends InputMismatchException {
    public InputNotLineException() {
        super("선이 아닙니다.");
    }
}
