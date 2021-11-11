package coordinate.domain;

import coordinate.domain.vo.Point;

import java.util.List;

public class StraightLine extends AbstractFigure implements Line {

    private static final int NUMBER_OF_LINE_POINTS = 2;
    private static final String INVALID_NUMBER_OF_POINT_ERROR_MESSAGE = "선의 점의 개수는 2개여야 합니다";
    private static final double LINE_AREA = 0;

    public StraightLine(List<Point> points) {
        super(points);
        validateNumberOf(points);
    }

    private void validateNumberOf(final List<Point> points) {
        if (points.size() != NUMBER_OF_LINE_POINTS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_POINT_ERROR_MESSAGE);
        }
    }

    @Override
    public double area() {
        return LINE_AREA;
    }

    @Override
    public double length() {
        return points.get(0).distance(points.get(1));
    }


}
