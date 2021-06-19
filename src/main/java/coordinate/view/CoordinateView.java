package coordinate.view;

import java.io.PrintStream;

public class CoordinateView {
    private final PrintStream out = new PrintStream(System.out);

    public void showInputMessage() {
        out.print("* 좌표를 입력하세요.\n-> ");
    }

    public void showErrorMessage() {
        out.println("* 범위를 벗어났습니다.");
    }

    public void showCoordinate(String coordinate) {
        out.println(coordinate);
    }

    public void showLineLength(double length) {
        out.println("* 두 점 사이의 거리는 " + length);
    }

    public void showTriangleArea(double length) {
        out.println("* 삼각형의 넓이는 " + length);
    }

    public void showRectangleArea(double length) {
        out.println("* 사각형의 넓이는 " + length);
    }
}
