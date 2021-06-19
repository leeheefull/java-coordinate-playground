package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotSquareException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static coordinate.util.InputConstants.HYPHEN;
import static coordinate.util.InputConstants.SQUARE_HYPHEN_CNT;

public class Square {
    private final List<Point> points;
    private final List<Line> lines;

    public Square(String squareInfo) throws InputIndexOutNumberException {
        validate(squareInfo);
        String[] pointInfos = inputSplit(squareInfo);
        this.points = convertPoints(pointInfos);
        this.lines = convertLines();
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Line> getLines() {
        return lines;
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

    private void validate(String squareInfo) {
        if (!isSquare(squareInfo)) {
            throw new InputNotSquareException();
        }
    }

    private boolean isSquare(String squareInfo) {
        return getSeparatorCnt(squareInfo) == SQUARE_HYPHEN_CNT;
    }

    private int getSeparatorCnt(String squareInfo) {
        return (int) squareInfo.chars()
                .filter(c -> c == HYPHEN.charAt(0))
                .count();
    }

    private String[] inputSplit(String squareInfo) {
        return squareInfo.split(HYPHEN);
    }

    private List<Point> convertPoints(String[] pointInfos) throws InputIndexOutNumberException {
        return Arrays.asList(
                new Point(pointInfos[0]),
                new Point(pointInfos[1]),
                new Point(pointInfos[2]),
                new Point(pointInfos[3])
        );
    }

    private List<Line> convertLines() throws InputIndexOutNumberException {
        return Arrays.asList(
                new Line(points.get(0) + HYPHEN + points.get(1)),
                new Line(points.get(1) + HYPHEN + points.get(2)),
                new Line(points.get(2) + HYPHEN + points.get(3)),
                new Line(points.get(3) + HYPHEN + points.get(0))
        );
    }
}
