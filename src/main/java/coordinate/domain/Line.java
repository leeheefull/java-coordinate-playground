package coordinate.domain;

import coordinate.exception.InputNotLineException;

public class Line {
    private final Point point1;
    private final Point point2;

    private static final String SEPARATOR = "-";

    public Line(String lineInfo) {
        validate(lineInfo);
        String[] pointInfos = inputSplit(lineInfo);
        this.point1 = new Point(pointInfos[0]);
        this.point2 = new Point(pointInfos[1]);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public double getLength() {
        double calX = Math.pow(point1.getX().getNumber() - point2.getX().getNumber(), 2);
        double calY = Math.pow(point1.getY().getNumber() - point2.getY().getNumber(), 2);
        return Math.sqrt(calX + calY);
    }

    @Override
    public String toString() {
        return this.point1 + "-" + this.point2;
    }

    private void validate(String lineInfo) {
        if (!isLine(lineInfo)) {
            throw new InputNotLineException();
        }
    }

    private boolean isLine(String lineInfo) {
        return lineInfo.contains(SEPARATOR);
    }

    private String[] inputSplit(String lineInfo) {
        return lineInfo.split(SEPARATOR);
    }
}
