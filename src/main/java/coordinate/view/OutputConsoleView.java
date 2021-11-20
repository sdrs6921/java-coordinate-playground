package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Line;

import static java.lang.System.out;

public class OutputConsoleView implements OutputView {

    private static final String LINE_PRINT_FORMAT = "두 점 사이 거리는 %f%n";
    private static final String FIGURE_PRINT_FORMAT = "%s의 넓이는 %f%n";

    @Override
    public void printLine(final Line line) {
        out.printf(LINE_PRINT_FORMAT, line.length());
    }

    @Override
    public void printFigure(final Figure figure) {
        out.printf(FIGURE_PRINT_FORMAT, figure.figureType(), figure.area());
    }
}
