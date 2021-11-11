package coordinate.domain.vo;

import java.util.Objects;

public class Coordinate {


    private static final int MIN_COORDINATE_VALUE = 0;
    private static final int MAX_COORDINATE_VALUE = 24;
    private static final String INVALID_COORDINATE_VALUE_MESSAGE = "좌표 값은 0이상 24이하여야 합니다";

    private final int value;

    public Coordinate(final int value) {
        validateOutOfRange(value);
        this.value = value;
    }

    private void validateOutOfRange(final int value) {
        if (value < MIN_COORDINATE_VALUE || value > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException(INVALID_COORDINATE_VALUE_MESSAGE);
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
