package coordinate.domain;

import coordinate.util.Coordinate;

import java.util.List;

public interface Figure {
    List<Point> getPoints();

    double getArea();

    default String draw(List<Point> points) {
        return Coordinate.print(points);
    }
}
