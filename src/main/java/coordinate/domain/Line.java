package coordinate.domain;

import coordinate.exception.InputNotLineException;

import java.util.List;

public class Line implements Figure {
    private final List<Point> points;

    public Line(List<Point> linePoints) {
        validate(linePoints);
        this.points = linePoints;
    }

    @Override
    public List<Point> getPoints() {
        return this.points;
    }

    @Override
    public double getArea() {
        double calX = Math.pow(getXGap(), 2);
        double calY = Math.pow(getYGap(), 2);
        return Math.sqrt(calX + calY);
    }

    public double getInclination() {
        return getYGap() * 1.0 / getXGap();
    }

    public boolean containPoint(Point meetPoint) {
        return this.points.stream()
                .filter(point -> point.getX().getNumber() == meetPoint.getX().getNumber())
                .filter(point -> point.getY().getNumber() == meetPoint.getY().getNumber())
                .count() == 1;
    }

    private void validate(List<Point> linePoints) {
        if (isEqualPoints(linePoints)) {
            throw new InputNotLineException();
        }
    }

    private boolean isEqualPoints(List<Point> linePoints) {
        return isXEqual(linePoints) && isYEqual(linePoints);
    }

    private boolean isXEqual(List<Point> linePoints) {
        return linePoints.get(0).getX().getNumber() == linePoints.get(1).getX().getNumber();
    }

    private boolean isYEqual(List<Point> linePoints) {
        return linePoints.get(0).getY().getNumber() == linePoints.get(1).getY().getNumber();
    }

    private int getXGap() {
        return this.points.get(1).getX().getNumber() - this.points.get(0).getX().getNumber();
    }

    private int getYGap() {
        return this.points.get(1).getY().getNumber() - this.points.get(0).getY().getNumber();
    }
}
