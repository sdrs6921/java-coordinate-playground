package rentcar.domain.car.vo;

public class DistancePerLiter {

    private final double value;

    public DistancePerLiter(final double value) {
        validateGreaterThanZero(value);
        this.value = value;
    }

    private void validateGreaterThanZero(final double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("0 초과의 수 여야 합니다");
        }
    }

    public double getValue() {
        return value;
    }
}
