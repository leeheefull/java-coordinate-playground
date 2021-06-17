package coordinate.domain;

import coordinate.exception.InputNotTriangleException;
import coordinate.util.Coordinate;

import java.util.Arrays;
import java.util.List;

public class Triangle implements Drawable {
    private final List<Point> points;

    private static final int SEPARATOR_CNT = 2;

    public Triangle(String triangleInfo) {
        validate(triangleInfo);
        String[] pointInfos = inputSplit(triangleInfo);
        this.points = Arrays.asList(
                new Point(pointInfos[0]),
                new Point(pointInfos[1]),
                new Point(pointInfos[2])
        );
    }

    public List<Point> getPoints() {
        return points;
    }

    // 구현 중
    public int getArea() {
        return 0;
    }

    @Override
    public String draw() {
        return Coordinate.print(this.getPoints());
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
}
