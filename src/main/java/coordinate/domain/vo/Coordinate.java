package coordinate.domain.vo;

import java.util.Objects;

public class Coordinate {


    private static final int MIN_X_VALUE = 0;
    private static final int MAX_X_VALUE = 24;

    private final int value;

    public Coordinate(final int value) {
        validateOutOfRange(value);
        this.value = value;
    }

    private void validateOutOfRange(final int value) {
        if (value < MIN_X_VALUE || value > MAX_X_VALUE) {
            throw new IllegalArgumentException("x값은 0이상 24이하여야 합니다");
        }
    }

    public int distance(final Coordinate other) {
        return Math.abs(this.value() - other.value());
    }

    private int value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        final Coordinate that = (Coordinate) o;
        return value() == that.value();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
