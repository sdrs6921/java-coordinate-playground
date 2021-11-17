package coordinate.domain;

import coordinate.domain.vo.Coordinate;
import coordinate.domain.vo.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Rectangle implements Figure {

    private static final int NUMBER_OF_RECTANGLE_POINTS = 4;
    private static final int NUMBER_OF_DUPLICATED_COORDINATE = 2;

    private static final String INVALID_NUMBER_OF_RECTANGLE_POINTS_MESSAGE = "사각형의 점은 4개여야 합니다";
    private static final String INVALID_RECTANGLE_MESSAGE = "직사각형이 아닙니다";
    private static final String DUPLICATE_POINTS_EXCEPTION_MESSAGE = "점 사이에 중복이 존재합니다";

    private final List<Point> points;

    public Rectangle(final List<Point> points) {
        validateNumberOf(points);
        validateDuplicateOf(points);
        validateIsRectangle(points);
        this.points = points;
    }

    private void validateNumberOf(final List<Point> points) {
        if (points.size() != NUMBER_OF_RECTANGLE_POINTS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_RECTANGLE_POINTS_MESSAGE);
        }
    }

    private void validateDuplicateOf(final List<Point> points) {
        Set<Point> distinctPoints = new HashSet<>(points);

        if (distinctPoints.size() < points.size()) {
            throw new IllegalArgumentException(DUPLICATE_POINTS_EXCEPTION_MESSAGE);
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

    private List<Point> points() {
        return points;
    }

    @Override
    public double area() {
        Point point = points.get(0);
        Point sameXCoordinatePoint = getSameCoordinatePoint(point::hasSameXCoordinate);
        Point sameYCoordinatePoint = getSameCoordinatePoint(point::hasSameYCoordinate);

        Line width = new StraightLine(asList(point, sameXCoordinatePoint));
        Line height = new StraightLine(asList(point, sameYCoordinatePoint));

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

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (!(other instanceof Rectangle)) return false;
        final Rectangle rectangle = (Rectangle) other;
        return points().equals(rectangle.points());
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
