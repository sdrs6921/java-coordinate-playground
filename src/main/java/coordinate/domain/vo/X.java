package coordinate.domain.vo;

import java.util.Objects;

public class X {

    private static final int MIN_X_VALUE = 0;
    private static final int MAX_X_VALUE = 24;

    private final int value;

    public X(final int value) {
        validateOutOfRange(value);
        this.value = value;
    }

    private void validateOutOfRange(final int value) {
        if (value < MIN_X_VALUE || value > MAX_X_VALUE) {
            throw new IllegalArgumentException("x값은 0이상 24이하여야 합니다");
        }
    }

    public int distance(final X otherX) {
        return Math.abs(this.value() - otherX.value());
    }

    private int value() {
        return value;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (!(object instanceof X)) return false;
        final X x = (X) object;
        return value() == x.value();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
