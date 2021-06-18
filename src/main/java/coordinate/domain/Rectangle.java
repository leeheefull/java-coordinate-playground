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

    private boolean isPerfectSquare() {
        return getTwoDifferentLine().size() == DIFFERENT_LINE_CNT_1;
    }

    private boolean isRectangle() {
        return getTwoDifferentLine().size() == DIFFERENT_LINE_CNT_2;
    }

    private List<Double> getTwoDifferentLine() {
        return this.getLines().stream()
                .map(Line::getLength)
                .distinct()
                .collect(Collectors.toList());
    }
}
