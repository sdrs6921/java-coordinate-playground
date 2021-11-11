package coordinate.domain;

import coordinate.domain.vo.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure implements Figure {

    private static final String DUPLICATE_POINTS_MESSAGE = "점들 사이에 중복이 존재합니다";
    protected final List<Point> points;

    protected AbstractFigure(final List<Point> points) {
        validateDuplicateOf(points);
        this.points = points;
    }

    private void validateDuplicateOf(final List<Point> points) {
        HashSet<Point> set = new HashSet<>(points);

        if (set.size() != points.size()) {
            throw new IllegalArgumentException(DUPLICATE_POINTS_MESSAGE);
        }
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
