package coordinate.exception;

public class InputIndexOutNumberException extends IllegalStateException {
    public InputIndexOutNumberException() {
        super("숫자 범위가 벗어났습니다.");
    }
}
