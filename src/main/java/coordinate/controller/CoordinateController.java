package coordinate.controller;

import coordinate.domain.Figure;
import coordinate.domain.FigureFactory;
import coordinate.domain.Line;
import coordinate.domain.StraightLine;
import coordinate.domain.vo.Point;
import coordinate.view.InputView;
import coordinate.view.OutputView;

import java.util.List;

public class CoordinateController {

    private static final int NUMBER_OF_LINE = 2;

    private final InputView inputView;
    private final OutputView outputView;

    public CoordinateController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<Point> points = inputView.input();

        if (isLineNumberOf(points)) {
            printLine(points);
            return;
        }

        printFigure(points);
    }

    private boolean isLineNumberOf(final List<Point> points) {
        return points.size() == NUMBER_OF_LINE;
    }

    private void printLine(final List<Point> points) {
        Line line = new StraightLine(points);
        outputView.printLine(line);
    }

    private void printFigure(final List<Point> points) {
        Figure figure = FigureFactory.create(points);
        outputView.printFigure(figure);
    }
}
