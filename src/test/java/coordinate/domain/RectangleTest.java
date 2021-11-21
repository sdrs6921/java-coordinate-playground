package coordinate.domain;

import coordinate.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleTest {

    @Test
    @DisplayName("점 4개를 인자로 받아 점을 생성한다")
    void create() {
        //given
        List<Point> points =
                asList(new Point(0, 0), new Point(1, 1), new Point(0, 1), new Point(1, 0));

        //when
        Rectangle rectangle = new Rectangle(points);

        //then
        assertThat(rectangle).isEqualTo(new Rectangle(points));
    }

    @Test
    @DisplayName("점이 4개가 아니면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_number_of_points() {
        //given
        List<Point> points = Collections.singletonList(new Point(1, 1));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Rectangle(points))
                .withMessage("사각형의 점은 4개여야 합니다");
    }

    @ParameterizedTest
    @MethodSource("isNotRectanglePoints")
    @DisplayName("직사각형을 이루는 점이 아니라면 예외를 발생시킨다")
    void create_throw_exception_with_is_not_rectangle_points(final List<Point> points) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Rectangle(points))
                .withMessage("직사각형이 아닙니다");
    }

    @Test
    @DisplayName("")
    void create_throw_exception_with_duplicate_points() {
        //given
        List<Point> points =
                asList(new Point(0, 0), new Point(0, 0), new Point(1, 1), new Point(1, 1));
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Rectangle(points))
                .withMessage("점 사이에 중복이 존재합니다");
    }

    static Stream<Arguments> isNotRectanglePoints() {
        return Stream.of(
                arguments(
                        asList(
                                new Point(0, 0), new Point(1, 0),
                                new Point(2, 0), new Point(3, 0)),
                        asList(
                                new Point(0, 0), new Point(0, 1),
                                new Point(0, 2), new Point(0, 3)),
                        asList(
                                new Point(0, 0), new Point(1, 0),
                                new Point(0, 1), new Point(1, 2)),
                        asList(
                                new Point(0, 0), new Point(1, 1),
                                new Point(2, 2), new Point(3, 3))));
    }

    @Test
    @DisplayName("넓이를 반환한다")
    void area() {
        //given
        List<Point> points =
                asList(new Point(0, 0), new Point(1, 1), new Point(0, 1), new Point(1, 0));
        Rectangle rectangle = new Rectangle(points);

        //when
        double area = rectangle.area();

        //then
        assertThat(area).isEqualTo(1, offset(0.001));
    }
}
