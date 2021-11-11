package coordinate.domain;

import coordinate.domain.vo.Point;

import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {

    protected final List<Point> points;

    protected AbstractFigure(final List<Point> points) {
        this.points = points;
    }

    private List<Point> points() {
        return points;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (!(other instanceof AbstractFigure)) return false;
        final AbstractFigure figure = (AbstractFigure) other;
        return points().equals(figure.points());
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
