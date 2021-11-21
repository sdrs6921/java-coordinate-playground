package rentcar.domain.car;

public abstract class Car {

    protected abstract double getDistancePerLiter();

    protected abstract double getTripDistance();

    public abstract String getName();

    public double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }
}
