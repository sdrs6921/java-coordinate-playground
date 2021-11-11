package coordinate.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class YTest {

    @Test
    @DisplayName("y값을 생성한다")
    void create() {
        //given
        int value = 0;

        //when
        Y y = new Y(value);

        //then
        assertThat(y).isEqualTo(new Y(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 25})
    @DisplayName("0미만 24초과의 값은 예외를 발생시킨다")
    void create_throw_exception_with_out_of_range_value(final int outOfRangeValue) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Y(outOfRangeValue))
                .withMessageContaining("y값은 0이상 24이하여야 합니다");
    }

    @Test
    @DisplayName("다른 Y 값과의 거리를 반환한다")
    void distance() {
        //given
        int value = 1;
        Y y = new Y(value);

        int otherValue = 0;
        Y otherY = new Y(otherValue);

        //when
        int distance = y.distance(otherY);

        //then
        assertThat(distance).isEqualTo(1);
    }
}
