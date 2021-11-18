package coordinate.domain;

import coordinate.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TriangleTest {

    @Test
    @DisplayName("삼각형을 생성한다")
    void create() {
        //given
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(1, 0), new Point(0, 3));

        //when
        Triangle triangle = new Triangle(points);

        //then
        assertThat(triangle).isEqualTo(new Triangle(points));
    }

    @Test
    @DisplayName("점이 3개가 아니라면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_number_of_points() {
        //given
        List<Point> points = Collections.singletonList(new Point(0, 0));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Triangle(points))
                .withMessage("삼각형의 점은 3개 여야 합니다");
    }

    @ParameterizedTest
    @MethodSource("isNotTrianglePoints")
    @DisplayName("점 3개가 삼각형이 아닐 경우 예외를 발생시킨다")
    void create_throw_exception_with_is_not_triangle(final List<Point> points) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Triangle(points))
                .withMessage("삼각형이 아닙니다");
    }

    static Stream<Arguments> isNotTrianglePoints() {
        return Stream.of(
                arguments(
                        Arrays.asList(new Point(0, 0), new Point(0, 1), new Point(0, 2)),
                        Arrays.asList(new Point(0, 0), new Point(1, 0), new Point(2, 0)),
                        Arrays.asList(new Point(0, 0), new Point(1, 1), new Point(2, 2))));
    }
}
