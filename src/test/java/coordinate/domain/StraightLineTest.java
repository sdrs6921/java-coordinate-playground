package coordinate.domain;

import coordinate.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.offset;

class StraightLineTest {

    @Test
    @DisplayName("선을 생성한다")
    void create() {
        //given
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(1, 1));

        //when
        Line line = new StraightLine(points);

        //then
        assertThat(line).isEqualTo(new StraightLine(points));

    }

    @Test
    @DisplayName("점의 개수가 2개 이상이면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_number_of_points() {
        //given
        List<Point> points = Collections.singletonList(new Point(0, 0));

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new StraightLine(points))
                .withMessageContaining("선의 점의 개수는 2개여야 합니다");
    }

    @Test
    @DisplayName("선의 길이를 반환한다")
    void length() {
        //given
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(1, 1));
        Line line = new StraightLine(points);

        //when
        double length = line.length();

        assertThat(length).isEqualTo(1.414, offset(0.001));
    }
}
