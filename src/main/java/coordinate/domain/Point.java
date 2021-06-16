package coordinate.domain;

public class Point {
    private final Number x;
    private final Number y;

    private static final String SEPARATOR = "[(,)]";

    public Point(String point) {
        String[] value = inputSplit(point);
        this.x = new Number(value[1]);
        this.y = new Number(value[2]);
    }

    public Number getX() {
        return x;
    }

    public Number getY() {
        return y;
    }

    private String[] inputSplit(String point) {
        return point.split(SEPARATOR);
    }
}
