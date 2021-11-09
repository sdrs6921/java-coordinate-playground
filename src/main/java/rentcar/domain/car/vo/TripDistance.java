package rentcar.domain.car.vo;

public class TripDistance {

    private final double value;

    public TripDistance(final double value) {
        validateZeroOrMore(value);
        this.value = value;
    }

    private void validateZeroOrMore(final double value) {
        if (value < 0) {
            throw new IllegalArgumentException("0 이상의 수어야 합니다");
        }
    }

    public double getValue() {
        return value;
    }
}
