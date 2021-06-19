package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotLineException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static coordinate.domain.InputConstants.HYPHEN;
import static coordinate.domain.InputConstants.LINE_HYPHEN_CNT;

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
        double calX = Math.pow(points.get(0).getX().getNumber() - points.get(1).getX().getNumber(), 2);
        double calY = Math.pow(points.get(0).getY().getNumber() - points.get(1).getY().getNumber(), 2);
        return Math.sqrt(calX + calY);
    }

    public String draw() {
        return Coordinate.print(this.getPoints());
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining(HYPHEN));
    }

    private void validate(String lineInfo) {
        if (!isLine(lineInfo)) {
            throw new InputNotLineException();
        }
    }

    private boolean isLine(String lineInfo) {
        return getSeparatorCnt(lineInfo) == LINE_HYPHEN_CNT;
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
}
