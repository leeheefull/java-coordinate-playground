package coordinate.exception;

public class InputNotNumberException extends NumberFormatException {
    public InputNotNumberException() {
        super("숫자가 아닙니다.");
    }
}
