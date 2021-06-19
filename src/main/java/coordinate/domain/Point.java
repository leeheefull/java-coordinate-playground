package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotPointException;

import static coordinate.domain.InputConstants.*;

public class Point {
    private final Number x;
    private final Number y;

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
        return BRACKET_START
                + this.x
                + COMMA
                + this.y
                + BRACKET_END;
    }

    private void validate(String pointInfo) {
        if (!isPoint(pointInfo)) {
            throw new InputNotPointException();
        }
    }

    private boolean isPoint(String pointInfo) {
        return pointInfo.contains(BRACKET_START)
                && pointInfo.contains(BRACKET_END)
                && pointInfo.contains(COMMA);
    }

    private String[] inputSplit(String pointInfo) {
        return pointInfo.split(SEPARATORS);
    }
}
