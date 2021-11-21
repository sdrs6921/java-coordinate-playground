package coordinate.domain;

import coordinate.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class FigureFactoryTest {

    @Test
    @DisplayName("점 3개를 입력받아 삼각형을 생성한다")
    void create_rectangle() {
        //given
        List<Point> points = asList(new Point(1, 1), new Point(2, 2), new Point(3, 1));

        //when
        Figure actual = FigureFactory.create(points);

        //then
        assertThat(actual).isEqualTo(new Triangle(points));
    }

    @Test
    @DisplayName("점 4개를 입력받아 사각형을 생성한다")
    void create_triangle() {
        //given
        List<Point> points =
                asList(new Point(1, 1), new Point(2, 1), new Point(1, 2), new Point(2, 2));

        //when
        Figure actual = FigureFactory.create(points);

        //then
        assertThat(actual).isEqualTo(new Rectangle(points));
    }
}
