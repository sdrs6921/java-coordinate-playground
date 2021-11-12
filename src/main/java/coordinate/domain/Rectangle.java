package coordinate.domain;

import coordinate.domain.vo.Coordinate;
import coordinate.domain.vo.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rectangle extends AbstractFigure {

    private static final int NUMBER_OF_RECTANGLE_POINTS = 4;
    private static final int NUMBER_OF_DUPLICATED_COORDINATE = 2;

    private static final String INVALID_NUMBER_OF_RECTANGLE_POINTS = "사각형의 점은 4개여야 합니다";
    private static final String INVALID_RECTANGLE_MESSAGE = "직사각형이 아닙니다";

    public Rectangle(final List<Point> points) {
        super(points);
        validateNumberOf(points);
        validateIsRectangle(points);
    }

    private void validateNumberOf(final List<Point> points) {
        if (points.size() != NUMBER_OF_RECTANGLE_POINTS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_RECTANGLE_POINTS);
        }
    }

    private void validateIsRectangle(final List<Point> points) {
        Set<Coordinate> duplicatedRemovedXCoordinate = removeDuplicateCoordinate(points, Point::x);
        Set<Coordinate> duplicatedRemovedYCoordinate = removeDuplicateCoordinate(points, Point::y);

        if (hasTwo(duplicatedRemovedXCoordinate) && hasTwo(duplicatedRemovedYCoordinate)) {
            throw new IllegalArgumentException(INVALID_RECTANGLE_MESSAGE);
        }
    }

    private Set<Coordinate> removeDuplicateCoordinate(final List<Point> points,
                                                      final Function<Point, Coordinate> extractedFunction) {
        return points.stream()
                .map(extractedFunction)
                .collect(Collectors.toSet());
    }

    private boolean hasTwo(final Set<Coordinate> duplicatedRemovedCoordinate) {
        return duplicatedRemovedCoordinate.size() != NUMBER_OF_DUPLICATED_COORDINATE;
    }

    @Override
    public double area() {
        Point point = points.get(0);
        Point sameXCoordinatePoint = getSameCoordinatePoint(point::hasSameXCoordinate);
        Point sameYCoordinatePoint = getSameCoordinatePoint(point::hasSameYCoordinate);

        Line width = new StraightLine(Arrays.asList(point, sameXCoordinatePoint));
        Line height = new StraightLine(Arrays.asList(point, sameYCoordinatePoint));

        return width.length() * height.length();
    }

    private Point getSameCoordinatePoint(final Predicate<Point> hasSameCoordinatePredicate) {
        int startIndex = 1;

        return IntStream.range(startIndex, points.size())
                .mapToObj(points::get)
                .filter(hasSameCoordinatePredicate)
                .findAny()
                .orElseThrow(() -> new IllegalStateException(INVALID_RECTANGLE_MESSAGE));
    }
}
