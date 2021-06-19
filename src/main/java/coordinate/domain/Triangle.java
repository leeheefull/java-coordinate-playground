package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotTriangleException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static coordinate.domain.InputConstants.HYPHEN;
import static coordinate.domain.InputConstants.TRIANGLE_HYPHEN_CNT;

public class Triangle {
    private final List<Point> points;
    private final List<Line> lines;

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

    public String draw() {
        return Coordinate.print(this.convertPoints());
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(HYPHEN));
    }

    private void validate(String triangleInfo) {
        if (!isTriangle(triangleInfo)) {
            throw new InputNotTriangleException();
        }
    }

    private boolean isTriangle(String triangleInfo) {
        return getSeparatorCnt(triangleInfo) == TRIANGLE_HYPHEN_CNT;
    }

    private int getSeparatorCnt(String triangleInfo) {
        return (int) triangleInfo.chars()
                .filter(c -> c == HYPHEN.charAt(0))
                .count();
    }

    private String[] inputSplit(String triangleInfo) {
        return triangleInfo.split(HYPHEN);
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
                new Line(points.get(0) + HYPHEN + points.get(1)),
                new Line(points.get(1) + HYPHEN + points.get(2)),
                new Line(points.get(2) + HYPHEN + points.get(0))
        );
    }

    private double getHeron() {
        return this.lines.stream()
                .map(Line::getLength)
                .mapToDouble(Double::doubleValue)
                .sum() / 2;
    }
}
