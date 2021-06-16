package coordinate.domain;

import coordinate.exception.InputNotNumberException;

public class Point {
    private final int x;
    private final int y;

    private static final String SEPARATOR = "[(,)]";
    private static final String NUMBER_REGEX = "^[0-9]*$";

    public Point(String point) {
        String[] value = inputSplit(point);
        validate(value[1], value[2]);
        this.x = Integer.parseInt(value[1]);
        this.y = Integer.parseInt(value[2]);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private String[] inputSplit(String point) {
        return point.split(SEPARATOR);
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
