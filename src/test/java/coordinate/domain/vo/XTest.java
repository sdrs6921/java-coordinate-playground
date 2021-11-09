package coordinate.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class XTest {

    @Test
    @DisplayName("x값을 생성한다")
    void create() {
        //given
        int value = 0;

        //when
        X x = new X(value);

        //then
        assertThat(x).isEqualTo(new X(value));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 25})
    @DisplayName("0미만 24초과의 값은 예외를 발생시킨다")
    void create_throw_exception_with_out_of_range(final int outOfRangeValue) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new X(outOfRangeValue))
                .withMessageContaining("x값은 0이상 24이하여야 합니다");
    }
}
