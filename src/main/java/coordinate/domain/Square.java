package coordinate.domain;

import coordinate.exception.InputNotSquareException;

import java.util.Arrays;
import java.util.List;

public abstract class Square implements Figure {
    private final List<Line> lines;

    public Square(List<Point> squarePoints) {
        validate(squarePoints);
        this.lines = convertLines(squarePoints);
    }

    public List<Line> getLines() {
        return this.lines;
    }

    @Override
    public List<Point> getPoints() {
        return Arrays.asList(
                new Point(this.lines.get(0).getPoints().get(0).getX(), this.lines.get(0).getPoints().get(0).getY()),
                new Point(this.lines.get(1).getPoints().get(0).getX(), this.lines.get(1).getPoints().get(0).getY()),
                new Point(this.lines.get(2).getPoints().get(0).getX(), this.lines.get(2).getPoints().get(0).getY()),
                new Point(this.lines.get(3).getPoints().get(0).getX(), this.lines.get(3).getPoints().get(0).getY())
        );
    }

    @Override
    public abstract double getArea();

    private void validate(List<Point> squarePoints) {
        if (isNotSquare(squarePoints)) {
            throw new InputNotSquareException();
        }
    }

    private boolean isNotSquare(List<Point> squarePoints) {
        return isXEqual(squarePoints) || isYEqual(squarePoints);
    }

    private boolean isXEqual(List<Point> squarePoints) {
        return squarePoints.get(0).getX().getNumber() == squarePoints.get(1).getX().getNumber()
                && squarePoints.get(1).getX().getNumber() == squarePoints.get(2).getX().getNumber()
                && squarePoints.get(2).getX().getNumber() == squarePoints.get(3).getX().getNumber();
    }

    private boolean isYEqual(List<Point> squarePoints) {
        return squarePoints.get(0).getY().getNumber() == squarePoints.get(1).getY().getNumber()
                && squarePoints.get(1).getY().getNumber() == squarePoints.get(2).getY().getNumber()
                && squarePoints.get(2).getY().getNumber() == squarePoints.get(3).getY().getNumber();
    }

    private List<Line> convertLines(List<Point> squarePoints) {
        return Arrays.asList(
                new Line(Arrays.asList(squarePoints.get(0), squarePoints.get(1))),
                new Line(Arrays.asList(squarePoints.get(1), squarePoints.get(2))),
                new Line(Arrays.asList(squarePoints.get(2), squarePoints.get(3))),
                new Line(Arrays.asList(squarePoints.get(3), squarePoints.get(0)))
        );
    }
}
