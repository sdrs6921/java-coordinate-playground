package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Line;

public interface OutputView {

    void printLine(final Line line);

    void printFigure(final Figure figure);
}
