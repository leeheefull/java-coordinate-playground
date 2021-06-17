package coordinate.domain;

import coordinate.exception.InputNotLineException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;

public class Line implements Drawable {
    private final List<Point> points;

    private static final int SEPARATOR_CNT = 1;

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

    @Override
    public String draw() {
        return Coordinate.print(this.getPoints());
    }

    @Override
    public String toString() {
        return this.points.get(0) + SEPARATOR + this.points.get(1);
    }

    private void validate(String lineInfo) {
        if (!isLine(lineInfo)) {
            throw new InputNotLineException();
        }
    }

    private boolean isLine(String lineInfo) {
        return getSeparatorCnt(lineInfo) == SEPARATOR_CNT;
    }

    private int getSeparatorCnt(String lineInfo) {
        return (int) lineInfo.chars()
                .filter(c -> c == SEPARATOR.charAt(0))
                .count();
    }

    private String[] inputSplit(String lineInfo) {
        return lineInfo.split(SEPARATOR);
    }
}
