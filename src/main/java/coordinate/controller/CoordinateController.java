package coordinate.controller;

import coordinate.domain.Figure;
import coordinate.domain.FigureType;
import coordinate.exception.InputIndexOutNumberException;
import coordinate.view.CoordinateView;

import java.util.Scanner;

public class CoordinateController {
    private final CoordinateView view = new CoordinateView();

    public void run() {
        try {
            String pointsInfo = InputPointsInfo();
            Figure figure = FigureType.of(pointsInfo);
            view.showCoordinate(figure.draw(figure.getPoints()));
            view.showFigureArea(figure.getArea());
        } catch (InputIndexOutNumberException e) {
            view.showErrorMessage();
            run();
        }
    }

    private String InputPointsInfo() {
        view.showInputMessage();
        return new Scanner(System.in).next();
    }
}