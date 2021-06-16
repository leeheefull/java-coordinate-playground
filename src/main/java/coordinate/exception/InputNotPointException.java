package coordinate.exception;

import java.util.InputMismatchException;

public class InputNotPointException extends InputMismatchException {
    public InputNotPointException() {
        super("점이 아닙니다.");
    }
}
