package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public enum FigureType {
    LINE(2) {
        @Override
        public Figure getFigure(List<Point> figureInfo) {
            return new Line(figureInfo);
        }
    },
    TRIANGLE(3) {
        @Override
        public Figure getFigure(List<Point> figureInfo) {
            return new Triangle(figureInfo);
        }
    },
    RECTANGLE(4) {
        @Override
        public Figure getFigure(List<Point> figureInfo) {
            return new Rectangle(figureInfo);
        }
    };

    private final int pointCnt;

    private static final String SEPARATORS = "[()-]";

    FigureType(int pointCnt) {
        this.pointCnt = pointCnt;
    }

    public abstract Figure getFigure(List<Point> figureInfo);

    public static Figure of(String figureInfo) throws InputIndexOutNumberException {
        List<Point> points = convertPoints(figureInfo);
        return Arrays.stream(values())
                .filter(figureType -> figureType.pointCnt == points.size())
                .map(figureType -> figureType.getFigure(points))
                .findFirst()
                .get();
    }

    private static List<Point> convertPoints(String figureInfo) throws InputIndexOutNumberException {
        StringTokenizer st = new StringTokenizer(figureInfo, SEPARATORS);
        List<Point> points = new ArrayList<>();
        while (st.hasMoreTokens()) {
            points.add(new Point(st.nextToken()));
        }
        return points;
    }
}
