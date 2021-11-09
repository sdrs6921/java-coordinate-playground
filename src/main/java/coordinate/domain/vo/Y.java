package coordinate.domain.vo;

import java.util.Objects;

public class Y {

    private static final int MIN_Y_VALUE = 0;
    private static final int MAX_Y_VALUE = 24;

    private final int value;

    public Y(final int value) {
        validateOutOfRange(value);
        this.value = value;
    }

    private void validateOutOfRange(final int value) {
        if (value < MIN_Y_VALUE || value > MAX_Y_VALUE) {
            throw new IllegalArgumentException("y값은 0이상 24이하여야 합니다");
        }
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (!(object instanceof Y)) return false;
        final Y y = (Y) object;
        return value == y.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
