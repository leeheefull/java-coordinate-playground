package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotLineException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static coordinate.util.InputConstants.HYPHEN;
import static coordinate.util.InputConstants.LINE_HYPHEN_CNT;

public class Line {
    private final List<Point> points;

    public Line(String lineInfo) throws InputIndexOutNumberException {
        validate(lineInfo);
        String[] pointInfos = inputSplit(lineInfo);
        this.points = convertPoints(pointInfos);
    }

    public List<Point> getPoints() {
        return points;
    }

    public double getLength() {
        double calX = Math.pow(getXGap(), 2);
        double calY = Math.pow(getYGap(), 2);
        return Math.sqrt(calX + calY);
    }

    public String draw() {
        return Coordinate.print(this.getPoints());
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

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(HYPHEN));
    }

    private void validate(String lineInfo) throws InputIndexOutNumberException {
        if (!isLine(lineInfo) || isEqualPoints(lineInfo)) {
            throw new InputNotLineException();
        }
    }

    private boolean isLine(String lineInfo) {
        return getSeparatorCnt(lineInfo) == LINE_HYPHEN_CNT;
    }

    private boolean isEqualPoints(String lineInfo) throws InputIndexOutNumberException {
        List<Point> points = convertPoints(inputSplit(lineInfo));
        if (points.get(0).getX().getNumber() == points.get(1).getX().getNumber()) {
            return points.get(0).getY().getNumber() == points.get(1).getY().getNumber();
        }
        return false;
    }

    private int getSeparatorCnt(String lineInfo) {
        return (int) lineInfo.chars()
                .filter(c -> c == HYPHEN.charAt(0))
                .count();
    }

    private String[] inputSplit(String lineInfo) {
        return lineInfo.split(HYPHEN);
    }

    private List<Point> convertPoints(String[] pointInfos) throws InputIndexOutNumberException {
        return Arrays.asList(
                new Point(pointInfos[0]),
                new Point(pointInfos[1])
        );
    }

    private int getXGap() {
        return this.points.get(1).getX().getNumber() - this.points.get(0).getX().getNumber();
    }

    private int getYGap() {
        return this.points.get(1).getY().getNumber() - this.points.get(0).getY().getNumber();
    }
}
