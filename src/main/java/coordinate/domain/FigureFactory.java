package coordinate.domain;

import coordinate.domain.vo.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FigureFactory {

    private static final String INVALID_NUMBER_OF_POINTS_MESSAGE = "유효하지 않은 점의 개수입니다";
    private static final int NUMBER_OF_TRIANGLE_POINTS = 3;
    private static final int NUMBER_OF_RECTANGLE_POINTS = 4;

    private static final Map<Integer, Function<List<Point>, Figure>> factory = new HashMap<>();

    static {
        factory.put(NUMBER_OF_TRIANGLE_POINTS, Triangle::new);
        factory.put(NUMBER_OF_RECTANGLE_POINTS, Rectangle::new);
    }

    private FigureFactory() {

    }

    public static Figure create(final List<Point> points) {
        int numberOfPoints = points.size();
        validateNumberOfPoints(numberOfPoints);
        return factory.get(numberOfPoints).apply(points);
    }

    private static void validateNumberOfPoints(final int numberOfPoints) {
        if (numberOfPoints < NUMBER_OF_TRIANGLE_POINTS || numberOfPoints > NUMBER_OF_RECTANGLE_POINTS) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_POINTS_MESSAGE);
        }
    }
}
