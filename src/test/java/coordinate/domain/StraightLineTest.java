package coordinate.domain;

import coordinate.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

class StraightLineTest {

    @Test
    @DisplayName("선의 길이를 반환한다")
    void length() {
        Point firstPoint = new Point(0, 0);
        Point secondPoint = new Point(1, 1);
        Line line = new StraightLine(firstPoint, secondPoint);

        double length = line.length();

        assertThat(length).isEqualTo(1.414, offset(0.001));
    }
}
