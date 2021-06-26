package coordinate.domain;

import coordinate.exception.InputNotTriangleException;

import java.util.Arrays;
import java.util.List;

public class Triangle implements Figure {
    private final List<Line> lines;

    public Triangle(List<Point> trianglePoints) {
        validate(trianglePoints);
        this.lines = convertLines(trianglePoints);
    }

    @Override
    public List<Point> getPoints() {
        return Arrays.asList(
                new Point(this.lines.get(0).getPoints().get(0).getX(), this.lines.get(0).getPoints().get(0).getY()),
                new Point(this.lines.get(1).getPoints().get(0).getX(), this.lines.get(1).getPoints().get(0).getY()),
                new Point(this.lines.get(2).getPoints().get(0).getX(), this.lines.get(2).getPoints().get(0).getY())
        );
    }

    @Override
    public double getArea() {
        double heron = getHeron();
        return Math.sqrt(heron
                * (heron - this.lines.get(0).getArea())
                * (heron - this.lines.get(1).getArea())
                * (heron - this.lines.get(2).getArea())
        );
    }

    private void validate(List<Point> trianglePoints) {
        if (isNotTriangle(trianglePoints)) {
            throw new InputNotTriangleException();
        }
    }

    private boolean isNotTriangle(List<Point> trianglePoints) {
        return isXEqual(trianglePoints) || isYEqual(trianglePoints);
    }

    private boolean isXEqual(List<Point> trianglePoints) {
        return trianglePoints.get(0).getX().getNumber() == trianglePoints.get(1).getX().getNumber()
                && trianglePoints.get(1).getX().getNumber() == trianglePoints.get(2).getX().getNumber();
    }

    private boolean isYEqual(List<Point> trianglePoints) {
        return trianglePoints.get(0).getY().getNumber() == trianglePoints.get(1).getY().getNumber()
                && trianglePoints.get(1).getY().getNumber() == trianglePoints.get(2).getY().getNumber();
    }

    private List<Line> convertLines(List<Point> trianglePoints) {
        return Arrays.asList(
                new Line(Arrays.asList(trianglePoints.get(0), trianglePoints.get(1))),
                new Line(Arrays.asList(trianglePoints.get(1), trianglePoints.get(2))),
                new Line(Arrays.asList(trianglePoints.get(2), trianglePoints.get(0)))
        );
    }

    private double getHeron() {
        return this.lines.stream()
                .map(Line::getArea)
                .mapToDouble(Double::doubleValue)
                .sum() / 2;
    }
}
