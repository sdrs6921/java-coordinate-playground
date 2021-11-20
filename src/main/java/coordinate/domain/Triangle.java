package coordinate.domain;

import coordinate.domain.vo.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Triangle implements Figure {

    private static final String INVALID_NUMBER_OF_TRIANGLE_POINTS_MESSAGE = "삼각형의 점은 3개 여야 합니다";
    private static final int NUMBER_OF_TRIANGLE_POINTS = 3;
    private static final String INVALID_TRIANGLE_POINTS_EXCEPTION_MESSAGE = "삼각형이 아닙니다";
    private static final String DUPLICATED_POINTS_EXCEPTION_MESSAGE = "점 사이에 중복이 존재합니다";

    private final List<Point> points;

    public Triangle(final List<Point> points) {
        validateNumberOf(points);
        validateDuplicateOf(points);
        validateIsTriangle(points);
        this.points = points;
    }

    private void validateNumberOf(final List<Point> points) {
        if (points.size() != NUMBER_OF_TRIANGLE_POINTS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_TRIANGLE_POINTS_MESSAGE);
        }
    }

    private void validateDuplicateOf(final List<Point> points) {
        HashSet<Point> distinctPoints = new HashSet<>(points);

        if (distinctPoints.size() < points.size()) {
            throw new IllegalArgumentException(DUPLICATED_POINTS_EXCEPTION_MESSAGE);
        }
    }

    private void validateIsTriangle(final List<Point> points) {
        List<Line> sidesSortedByLengthDesc = getSidesOrderByLengthDescFrom(points);

        if (isLongestSideLongerThanSumOfOtherSides(sidesSortedByLengthDesc)) {
            throw new IllegalArgumentException(INVALID_TRIANGLE_POINTS_EXCEPTION_MESSAGE);
        }
    }

    private List<Line> getSidesOrderByLengthDescFrom(final List<Point> points) {
        return IntStream.range(0, points.size())
                .mapToObj(index -> asList(points.get(index), points.get((index + 1) % NUMBER_OF_TRIANGLE_POINTS)))
                .map(StraightLine::new)
                .sorted((line, other) -> (int) (other.length() - line.length()))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isLongestSideLongerThanSumOfOtherSides(final List<Line> sidesSortedByDesc) {
        return sidesSortedByDesc.get(0).length() >=
                sidesSortedByDesc.get(1).length() + sidesSortedByDesc.get(2).length();
    }

    private List<Point> points() {
        return points;
    }

    @Override
    public String figureType() {
        return "삼각형";
    }

    @Override
    public double area() {
        List<Line> sidesOrderByDesc = getSidesOrderByLengthDescFrom(points);
        return heronsFormula(sidesOrderByDesc);
    }

    private double heronsFormula(final List<Line> sidesOrderByDesc) {
        double halfPerimeter = calculateHalfPerimeter(sidesOrderByDesc);
        double areaSquared = calculateSquareOfArea(sidesOrderByDesc, halfPerimeter);
        return Math.sqrt(areaSquared);
    }

    private double calculateHalfPerimeter(final List<Line> sidesOrderByDesc) {
        double sumOfSides = sidesOrderByDesc.stream()
                .mapToDouble(Line::length)
                .sum();

        return sumOfSides / 2;
    }

    private double calculateSquareOfArea(final List<Line> sidesOrderByDesc, final double halfPerimeter) {
        return sidesOrderByDesc.stream()
                .mapToDouble(Line::length)
                .reduce(halfPerimeter, (total, side) -> total * (halfPerimeter - side));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        final Triangle triangle = (Triangle) o;
        return points().equals(triangle.points());
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
