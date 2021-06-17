package coordinate.util;

import coordinate.domain.Line;
import coordinate.domain.Point;
import coordinate.domain.Rectangle;
import coordinate.domain.Triangle;

import java.util.List;

public class Coordinate {
    private static final int COORDINATE_SIZE = 24;
    private static final String ORIGIN = "┼";
    private static final String X_AXIS = "─";
    private static final String Y_AXIS = "│";
    private static final String TAB = "\t";
    private static final String LINE_BREAK = "\n";
    private static final String BLANK = " ";
    private static final String POINT = "●";

    public static String print(List<Point> points) {
        StringBuilder output = new StringBuilder();
        for (int i = COORDINATE_SIZE; 0 <= i; i--) {
            drawOriginAndXAxis(output, i);
            drawYAxisAndBlankAndPoints(points, output, i);
            output.append(LINE_BREAK);
        }
        return output.toString();
    }

    private static void drawOriginAndXAxis(StringBuilder output, int i) {
        if (i == 0) {
            drawOrigin(output, i);
            drawXAxis(output);
        }
    }

    private static void drawOrigin(StringBuilder output, int i) {
        output.append(i).append(TAB).append(ORIGIN);
    }

    private static void drawXAxis(StringBuilder output) {
        for (int j = 0; j <= COORDINATE_SIZE; j++) {
            output.append(X_AXIS);
        }
    }

    private static void drawYAxisAndBlankAndPoints(List<Point> points, StringBuilder output, int i) {
        if (0 < i) {
            drawYAxis(output, i);
            drawBlankAndPoints(points, output, i);
        }
    }

    private static void drawYAxis(StringBuilder output, int i) {
        output.append(i).append(TAB).append(Y_AXIS);
    }

    private static void drawBlankAndPoints(List<Point> points, StringBuilder output, int i) {
        for (int j = 1; j <= COORDINATE_SIZE; j++) {
            j = drawPoints(points, output, i, j);
            output.append(BLANK);
        }
    }

    private static int drawPoints(List<Point> points, StringBuilder output, int i, int j) {
        for (Point point : points) {
            j = drawPoint(output, i, j, point);
        }
        return j;
    }

    private static int drawPoint(StringBuilder output, int i, int j, Point point) {
        if (isPointPosition(i, j, point)) {
            output.append(POINT);
            j++;
        }
        return j;
    }

    private static boolean isPointPosition(int i, int j, Point point) {
        return point.getY().getNumber() == i && point.getX().getNumber() == j;
    }

    public static void main(String[] args) {
        System.out.println(new Line("(10,10)-(14,15)").draw());
        System.out.println(new Rectangle("(10,10)-(22,10)-(22,18)-(10,18)").draw());
        System.out.println(new Triangle("(10,10)-(14,15)-(20,8)").draw());
    }
}
