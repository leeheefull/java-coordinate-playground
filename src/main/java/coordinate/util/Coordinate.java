package coordinate.util;

import coordinate.domain.Point;

import java.util.List;

public final class Coordinate {
    private static final int COORDINATE_SIZE = 24;
    private static final String ORIGIN = "┼";
    private static final String X_AXIS = "─";
    private static final String Y_AXIS = "│";
    private static final String TAB = "\t";
    private static final String LINE_BREAK = "\n";
    private static final String BLANK = " ";
    private static final String POINT = "●";

    private Coordinate() {
    }

    public static String makeOutput(List<Point> points) {
        StringBuilder output = new StringBuilder();
        for (int i = COORDINATE_SIZE; 0 <= i; i--) {
            output.append(drawOriginAndXAxis(i));
            output.append(drawYAxisAndBlankAndPoints(points, i));
            output.append(LINE_BREAK);
        }
        return output.toString();
    }

    private static StringBuilder drawOriginAndXAxis(int i) {
        StringBuilder output = new StringBuilder();
        if (i == 0) {
            output.append(drawOrigin(i));
            output.append(drawXAxis());
        }
        return output;
    }

    private static StringBuilder drawOrigin(int i) {
        return new StringBuilder().append(i).append(TAB).append(ORIGIN);
    }

    private static StringBuilder drawXAxis() {
        StringBuilder output = new StringBuilder();
        for (int j = 0; j <= COORDINATE_SIZE; j++) {
            output.append(X_AXIS);
        }
        return output;
    }

    private static StringBuilder drawYAxisAndBlankAndPoints(List<Point> points, int i) {
        StringBuilder output = new StringBuilder();
        if (0 < i) {
            output.append(drawYAxis(i));
            output.append(drawBlankAndPoints(points, i));
        }
        return output;
    }

    private static StringBuilder drawYAxis(int i) {
        return new StringBuilder().append(i).append(TAB).append(Y_AXIS);
    }

    private static StringBuilder drawBlankAndPoints(List<Point> points, int i) {
        StringBuilder output = new StringBuilder();
        for (int j = 1; j <= COORDINATE_SIZE; j++) {
            for (Point point : points) {
                if (isPointPosition(i, j, point)) {
                    output.append(POINT);
                    j++;
                }
            }
            output.append(BLANK);
        }
        return output;
    }

    private static boolean isPointPosition(int i, int j, Point point) {
        return point.getY().getNumber() == i && point.getX().getNumber() == j;
    }
}
