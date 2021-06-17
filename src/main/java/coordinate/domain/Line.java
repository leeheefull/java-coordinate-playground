package coordinate.domain;

import coordinate.exception.InputNotLineException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;

public class Line {
    private final List<Point> points;

    private static final String SEPARATOR = "-";

    public Line(String lineInfo) {
        validate(lineInfo);
        String[] pointInfos = inputSplit(lineInfo);
        this.points = Arrays.asList(
                new Point(pointInfos[0]),
                new Point(pointInfos[1])
        );
    }

    public List<Point> getPoints() {
        return points;
    }

    public double getLength() {
        double calX = Math.pow(points.get(0).getX().getNumber() - points.get(1).getX().getNumber(), 2);
        double calY = Math.pow(points.get(0).getY().getNumber() - points.get(1).getY().getNumber(), 2);
        return Math.sqrt(calX + calY);
    }

    public String drawLine() {
        return Coordinate.print(this.getPoints());
    }

    @Override
    public String toString() {
        return this.points.get(0) + "-" + this.points.get(1);
    }

    private void validate(String lineInfo) {
        if (!isLine(lineInfo)) {
            throw new InputNotLineException();
        }
    }

    private boolean isLine(String lineInfo) {
        return lineInfo.contains(SEPARATOR);
    }

    private String[] inputSplit(String lineInfo) {
        return lineInfo.split(SEPARATOR);
    }
}
