package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotRectangleException;

import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends Square {
    private static final int DIFFERENT_LINE_CNT_1 = 1;
    private static final int DIFFERENT_LINE_CNT_2 = 2;

    public Rectangle(String rectangleInfo) throws InputIndexOutNumberException {
        super(rectangleInfo);
        validate();
    }

    public double getArea() {
        if (isPerfectSquare()) {
            return Math.pow(getTwoDifferentLine().get(0), 2);
        }
        return getTwoDifferentLine().stream()
                .reduce((a, b) -> a * b)
                .get();
    }

    private void validate() {
        if (!isRectangle() && !isPerfectSquare()) {
            throw new InputNotRectangleException();
        }
    }

    private boolean isRectangle() {
        if (getTwoDifferentLine().size() != DIFFERENT_LINE_CNT_2) {
            return false;
        }
        return isRightAngle();
    }

    private boolean isRightAngle() {
        List<Line> crossLine = getCrossLine(this.getPoints().get(0));
        if (Double.isNaN(crossLine.get(0).getInclination()) || crossLine.get(1).getInclination() == 0) {
            return true;
        }
        if (Double.isNaN(crossLine.get(1).getInclination()) || crossLine.get(0).getInclination() == 0) {
            return true;
        }
        return crossLine.get(0).getInclination() * (-1.0) / crossLine.get(0).getInclination() == crossLine.get(1).getInclination();
    }

    private List<Line> getCrossLine(Point meetPoint) {
        return this.getLines().stream()
                .filter(line -> line.containPoint(meetPoint))
                .collect(Collectors.toList());
    }

    private boolean isPerfectSquare() {
        return getTwoDifferentLine().size() == DIFFERENT_LINE_CNT_1;
    }

    private List<Double> getTwoDifferentLine() {
        return this.getLines().stream()
                .map(Line::getLength)
                .distinct()
                .collect(Collectors.toList());
    }
}
