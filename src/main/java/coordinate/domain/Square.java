package coordinate.domain;

import coordinate.exception.InputNotSquareException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;

public class Square implements Drawable {
    private final List<Point> points;

    private static final int SEPARATOR_CNT = 3;

    public Square(String squareInfo) {
        validate(squareInfo);
        String[] pointInfos = inputSplit(squareInfo);
        this.points = Arrays.asList(
                new Point(pointInfos[0]),
                new Point(pointInfos[1]),
                new Point(pointInfos[2]),
                new Point(pointInfos[3])
        );
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String draw() {
        return Coordinate.print(this.getPoints());
    }

    private void validate(String squareInfo) {
        if (!isSquare(squareInfo)) {
            throw new InputNotSquareException();
        }
    }

    private boolean isSquare(String squareInfo) {
        return getSeparatorCnt(squareInfo) == SEPARATOR_CNT;
    }

    private int getSeparatorCnt(String squareInfo) {
        return (int) squareInfo.chars()
                .filter(c -> c == SEPARATOR.charAt(0))
                .count();
    }

    private String[] inputSplit(String squareInfo) {
        return squareInfo.split(SEPARATOR);
    }
}
