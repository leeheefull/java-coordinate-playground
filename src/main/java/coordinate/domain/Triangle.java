package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotTriangleException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;

public class Triangle implements Drawable {
    private final List<Point> points;
    private final List<Line> lines;

    private static final int SEPARATOR_CNT = 2;

    public Triangle(String triangleInfo) throws InputIndexOutNumberException {
        validate(triangleInfo);
        String[] pointInfos = inputSplit(triangleInfo);
        this.points = convertPoints(pointInfos);
        this.lines = convertLines();
    }

    public List<Point> convertPoints() {
        return points;
    }

    public double getArea() {
        double heron = getHeron();
        return Math.sqrt(heron
                * (heron - this.lines.get(0).getLength())
                * (heron - this.lines.get(1).getLength())
                * (heron - this.lines.get(2).getLength())
        );
    }

    @Override
    public String draw() {
        return Coordinate.print(this.convertPoints());
    }

    private void validate(String triangleInfo) {
        if (!isTriangle(triangleInfo)) {
            throw new InputNotTriangleException();
        }
    }

    private boolean isTriangle(String triangleInfo) {
        return getSeparatorCnt(triangleInfo) == SEPARATOR_CNT;
    }

    private int getSeparatorCnt(String triangleInfo) {
        return (int) triangleInfo.chars()
                .filter(c -> c == SEPARATOR.charAt(0))
                .count();
    }

    private String[] inputSplit(String triangleInfo) {
        return triangleInfo.split(SEPARATOR);
    }

    private List<Point> convertPoints(String[] pointInfos) throws InputIndexOutNumberException {
        return Arrays.asList(
                new Point(pointInfos[0]),
                new Point(pointInfos[1]),
                new Point(pointInfos[2])
        );
    }

    private List<Line> convertLines() throws InputIndexOutNumberException {
        return Arrays.asList(
                new Line(points.get(0) + SEPARATOR + points.get(1)),
                new Line(points.get(1) + SEPARATOR + points.get(2)),
                new Line(points.get(2) + SEPARATOR + points.get(0))
        );
    }

    private double getHeron() {
        return this.lines.stream()
                .map(Line::getLength)
                .mapToDouble(Double::doubleValue)
                .sum() / 2;
    }
}
