package coordinate.domain.vo;

import java.util.Objects;

public class Point {

    private static final int EXPONENT = 2;
    private static final int INVALID_X_INCREMENT = 0;

    private static final String INVALID_X_INCREMENT_EXCEPTION_MESSAGE = "x 변화량이 0일 경우 기울기가 무한대가 됩니다";

    private final Coordinate x;
    private final Coordinate y;

    public Point(final Coordinate x, final Coordinate y) {
        this.x = x;
        this.y = y;
    }

    public Point(final int x, final int y) {
        this(new Coordinate(x), new Coordinate(y));
    }

    public double distance(final Point otherPoint) {
        int xDistance = x().distance(otherPoint.x());
        int yDistance = y().distance(otherPoint.y());

        return Math.sqrt(Math.pow(xDistance, EXPONENT) + Math.pow(yDistance, EXPONENT));
    }

    public Coordinate x() {
        return x;
    }

    public Coordinate y() {
        return y;
    }

    public boolean hasSameXCoordinate(final Point otherPoint) {
        return x().equals(otherPoint.x);
    }

    public boolean hasSameYCoordinate(final Point otherPoint) {
        return y().equals(otherPoint.y());
    }

    public double absoluteSlopeValue(final Point otherPoint) {
        double xIncrement = x().absoluteIncrementValue(otherPoint.x());
        double yIncrement = y().absoluteIncrementValue(otherPoint.y());

        if (xIncrement == INVALID_X_INCREMENT) {
            throw new IllegalArgumentException(INVALID_X_INCREMENT_EXCEPTION_MESSAGE);
        }

        return yIncrement / xIncrement;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        final Point point = (Point) o;
        return x.equals(point.x) && y.equals(point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
