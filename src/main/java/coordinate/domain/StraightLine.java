package coordinate.domain;

import coordinate.domain.vo.Point;

public class StraightLine implements Line {

    private final Point firstPoint;
    private final Point secondPoint;

    public StraightLine(final Point firstPoint, final Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    @Override
    public double length() {
        return firstPoint.distance(secondPoint);
    }
}
