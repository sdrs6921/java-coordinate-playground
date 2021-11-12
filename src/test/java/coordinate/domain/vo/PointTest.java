package coordinate.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

    @Test
    @DisplayName("X 좌표와 Y 좌표를 입력받아 점을 생성한다")
    void create_with_x_and_y() {
        //given
        int xValue = 0;
        int yValue = 0;

        Coordinate x = new Coordinate(xValue);
        Coordinate y = new Coordinate(yValue);

        //when
        Point point = new Point(x, y);

        //then
        assertThat(point).isEqualTo(new Point(x, y));
    }

    @Test
    @DisplayName("X 좌표값과 Y 좌표값을 입력받아 점을 생성한다")
    void create_with_x_value_and_y_value() {
        //given
        int xValue = 0;
        int yValue = 0;

        //when
        Point point = new Point(xValue, yValue);

        //then
        assertThat(point).isEqualTo(new Point(xValue, yValue));
    }

    @Test
    @DisplayName("두 점 사이의 거리를 반환한다")
    void distance() {
        //given
        Point point = new Point(0, 0);
        Point otherPoint = new Point(1, 1);

        //when
        double distance = point.distance(otherPoint);

        //then
        assertThat(distance).isEqualTo(1.414, offset(0.001));
    }

    @Test
    @DisplayName("x 좌표를 반환한다")
    void x() {
        //given
        int xValue = 1;
        int yValue = 1;
        Point point = new Point(xValue, yValue);

        //when
        Coordinate x = point.x();

        //then
        assertThat(x).isEqualTo(new Coordinate(xValue));
    }

    @Test
    @DisplayName("y 좌표를 반환한다")
    void y() {
        //given
        int xValue = 1;
        int yValue = 1;
        Point point = new Point(xValue, yValue);

        //when
        Coordinate y = point.y();

        //then
        assertThat(y).isEqualTo(new Coordinate(yValue));
    }
}
