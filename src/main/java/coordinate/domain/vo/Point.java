package coordinate.domain.vo;

import java.util.Objects;

public class Point {

    private static final int EXPONENT = 2;

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
