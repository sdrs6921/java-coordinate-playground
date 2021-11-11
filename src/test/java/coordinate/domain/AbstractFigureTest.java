package coordinate.domain;

import coordinate.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AbstractFigureTest {

    @Test
    @DisplayName("점들을 인자로 받아 도형을 생성한다")
    void create() {
        //given
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(1, 1));

        //when
        AbstractFigure figure = new StraightLine(points);

        //then
        assertThat(figure).isEqualTo(new StraightLine(points));
    }

    @Test
    @DisplayName("점들 중 중복이 존재하면 예외를 발생시킨다")
    void create_throw_exception_with_duplicate_points() {
        //given
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(0, 0));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new StraightLine(points))
                .withMessage("점들 사이에 중복이 존재합니다");
    }
}
