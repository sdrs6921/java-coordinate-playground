package coordinate.domain;

import coordinate.domain.vo.Point;

import java.util.List;
import java.util.Objects;

public class StraightLine implements Line {

    private static final int NUMBER_OF_LINE_POINTS = 2;

    private static final String INVALID_NUMBER_OF_STRAIGHT_LINE_POINTS_EXCEPTION_MESSAGE = "선의 점의 개수는 2개여야 합니다";

    private final List<Point> points;

    public StraightLine(List<Point> points) {
        validateNumberOf(points);
        this.points = points;
    }

    private void validateNumberOf(final List<Point> points) {
        if (points.size() != NUMBER_OF_LINE_POINTS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_STRAIGHT_LINE_POINTS_EXCEPTION_MESSAGE);
        }
    }

    private List<Point> points() {
        return points;
    }

    @Override
    public double length() {
        return points.get(0).distance(points.get(1));
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (!(other instanceof StraightLine)) return false;
        final StraightLine that = (StraightLine) other;
        return points().equals(that.points());
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
