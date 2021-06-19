package coordinate.controller;

import coordinate.domain.Line;
import coordinate.domain.Rectangle;
import coordinate.domain.Triangle;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.view.CoordinateView;

import java.util.Scanner;

import static coordinate.util.InputConstants.*;

public class CoordinateController {
    private final CoordinateView view = new CoordinateView();

    public void run() {
        try {
            String pointsInfo = InputPointsInfo();
            isRunLine(pointsInfo);
            isRunTriangle(pointsInfo);
            isRunRectangle(pointsInfo);
        } catch (InputIndexOutNumberException e) {
            view.showErrorMessage();
            run();
        }
    }

    private String InputPointsInfo() {
        view.showInputMessage();
        return new Scanner(System.in).next();
    }

    private int getHyphenCnt(String pointInput) {
        return (int) pointInput.chars()
                .filter(c -> c == HYPHEN.charAt(0))
                .count();
    }

    private void isRunLine(String pointsInfo) throws InputIndexOutNumberException {
        if (getHyphenCnt(pointsInfo) == LINE_HYPHEN_CNT) {
            Line line = new Line(pointsInfo);
            view.showCoordinate(line.draw());
            view.showLineLength(line.getLength());
        }
    }

    private void isRunTriangle(String pointsInfo) throws InputIndexOutNumberException {
        if (getHyphenCnt(pointsInfo) == TRIANGLE_HYPHEN_CNT) {
            Triangle triangle = new Triangle(pointsInfo);
            view.showCoordinate(triangle.draw());
            view.showTriangleArea(triangle.getArea());
        }
    }

    private void isRunRectangle(String pointsInfo) throws InputIndexOutNumberException {
        if (getHyphenCnt(pointsInfo) == SQUARE_HYPHEN_CNT) {
            Rectangle rectangle = new Rectangle(pointsInfo);
            view.showCoordinate(rectangle.draw());
            view.showRectangleArea(rectangle.getArea());
        }
    }
}

/* Test Input
(10,10)-(14,15)
(10,10)-(14,15)-(20,8)
(10,10)-(22,10)-(22,18)-(10,18)
 */