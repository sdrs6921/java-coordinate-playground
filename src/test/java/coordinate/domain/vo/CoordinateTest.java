package coordinate.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CoordinateTest {

    @Test
    @DisplayName("x값을 생성한다")
    void create() {
        //given
        int value = 0;

        //when
        Coordinate coordinate = new Coordinate(value);

        //then
        assertThat(coordinate).isEqualTo(new Coordinate(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 25})
    @DisplayName("0미만 24초과의 값은 예외를 발생시킨다")
    void create_throw_exception_with_out_of_range(final int outOfRangeValue) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Coordinate(outOfRangeValue))
                .withMessageContaining("좌표 값은 0이상 24이하여야 합니다");
    }

    @Test
    @DisplayName("다른 X의 값과 거리를 반환한다")
    void distance() {
        //given
        int value = 1;
        Coordinate coordinate = new Coordinate(value);

        int otherValue = 2;
        Coordinate otherCoordinate = new Coordinate(otherValue);

        //when
        int distance = coordinate.distance(otherCoordinate);

        //then
        assertThat(distance).isEqualTo(1);
    }
}
