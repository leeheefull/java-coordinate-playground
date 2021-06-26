package coordinate.domain;

import coordinate.exception.InputNotRectangleException;

import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends Square {
    private static final int DIFFERENT_LINE_CNT_1 = 1;
    private static final int DIFFERENT_LINE_CNT_2 = 2;

    public Rectangle(List<Point> rectangleInfo) {
        super(rectangleInfo);
        validate();
    }

    @Override
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
        return isRightAngle() && getTwoDifferentLine().size() == DIFFERENT_LINE_CNT_2;
    }

    private boolean isRightAngle() {
        List<Line> crossLine = getCrossLine(this.getLines().get(0).getPoints().get(0));
        return isInclinationInfinity(crossLine) || isTwoLineRightAngle(crossLine);
    }

    private boolean isTwoLineRightAngle(List<Line> crossLine) {
        return crossLine.get(0).getInclination() * (-1.0) / crossLine.get(0).getInclination()
                == crossLine.get(1).getInclination();
    }

    private boolean isInclinationInfinity(List<Line> crossLine) {
        return Double.isNaN(crossLine.get(0).getInclination()) || crossLine.get(1).getInclination() == 0
                || Double.isNaN(crossLine.get(1).getInclination()) || crossLine.get(0).getInclination() == 0;
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
                .map(Line::getArea)
                .distinct()
                .collect(Collectors.toList());
    }
}
