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

    public void showFigureArea(double length) {
        out.println("* 길이 or 넓이: " + length);
    }
}
