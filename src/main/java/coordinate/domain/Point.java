package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotPointException;

public class Point {
    private final Number x;
    private final Number y;

    private static final String DELIMITER = ",";

    public Point(String pointInfo) throws InputIndexOutNumberException {
        validate(pointInfo);
        String[] numberInfos = inputSplit(pointInfo);
        this.x = new Number(numberInfos[0]);
        this.y = new Number(numberInfos[1]);
    }

    public Point(Number x, Number y) {
        this.x = x;
        this.y = y;
    }

    public Number getX() {
        return this.x;
    }

    public Number getY() {
        return this.y;
    }

    private void validate(String pointInfo) {
        if (!isPoint(pointInfo)) {
            throw new InputNotPointException();
        }
    }

    private boolean isPoint(String pointInfo) {
        return pointInfo.contains(DELIMITER);
    }

    private String[] inputSplit(String pointInfo) {
        return pointInfo.split(DELIMITER);
    }
}
