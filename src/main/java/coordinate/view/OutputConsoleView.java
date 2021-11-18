package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Line;
import coordinate.domain.Rectangle;
import coordinate.domain.Triangle;

import static java.lang.System.out;

public class OutputConsoleView implements OutputView {

    private static final String LINE_PRINT_FORMAT = "두 점 사이 거리는 %f%n";
    private static final String TRIANGLE_PRINT_FORMAT = "삼각형의 넓이는 %f%n";
    private static final String RECTANGLE_PRINT_FORMAT = "사각형의 넓이는 %f%n";

    @Override
    public void printLine(final Line line) {
        out.printf(LINE_PRINT_FORMAT, line.length());
    }

    @Override
    public void printFigure(final Figure figure) {
        if (figure instanceof Triangle) {
            out.printf(TRIANGLE_PRINT_FORMAT, figure.area());
        } else if (figure instanceof Rectangle) {
            out.printf(RECTANGLE_PRINT_FORMAT, figure.area());
        }
    }
}
