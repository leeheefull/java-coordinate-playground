package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotPointException;

public class Point {
    private final Number x;
    private final Number y;

    private static final String SEPARATOR = "[,)(]";

    public Point(String pointInfo) throws InputIndexOutNumberException {
        validate(pointInfo);
        String[] numberInfos = inputSplit(pointInfo);
        this.x = new Number(numberInfos[1]);
        this.y = new Number(numberInfos[2]);
    }

    public Number getX() {
        return this.x;
    }

    public Number getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ')';
    }

    private void validate(String pointInfo) {
        if (!isPoint(pointInfo)) {
            throw new InputNotPointException();
        }
    }

    private boolean isPoint(String pointInfo) {
        return pointInfo.contains("(") && pointInfo.contains(")") && pointInfo.contains(",");
    }

    private String[] inputSplit(String pointInfo) {
        return pointInfo.split(SEPARATOR);
    }
}
