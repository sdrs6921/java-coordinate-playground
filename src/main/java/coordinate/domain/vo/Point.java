package coordinate.domain.vo;

import java.util.Objects;

public class Point {

    private static final int EXPONENT = 2;

    private final X x;
    private final Y y;

    public Point(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    public Point(final int x, final int y) {
        this(new X(x), new Y(y));
    }

    public double distance(final Point otherPoint) {
        int xDistance = x().distance(otherPoint.x());
        int yDistance = y().distance(otherPoint.y());

        return Math.sqrt(Math.pow(xDistance, EXPONENT) + Math.pow(yDistance, EXPONENT));
    }

    private X x() {
        return x;
    }

    private Y y() {
        return y;
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
