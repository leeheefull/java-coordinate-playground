package coordinate.domain;

import coordinate.exception.InputNotNumberException;

public class Point {
    private final int x;
    private final int y;

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public Point(String x, String y) {
        validate(x, y);
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
    }

    private void validate(String x, String y) {
        if (!isNumber(x, y)) {
            throw new InputNotNumberException();
        }
    }

    private boolean isNumber(String x, String y) {
        return x.matches(NUMBER_REGEX) && y.matches(NUMBER_REGEX);
    }
}
