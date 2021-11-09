package coordinate.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("X 좌표와 Y 좌표를 입력받아 점을 생성한다")
    void create_with_x_and_y() {
        //given
        int xValue = 0;
        int yValue = 0;

        X x = new X(xValue);
        Y y = new Y(yValue);

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
}
