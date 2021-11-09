package rentcar.domain.car;

import rentcar.domain.car.vo.DistancePerLiter;
import rentcar.domain.car.vo.TripDistance;

public class Sonata extends Car {

    private static final int DISTANCE_PER_LITER = 10;

    private final TripDistance tripDistance;
    private final DistancePerLiter distancePerLiter;

    public Sonata(final TripDistance tripDistance, final DistancePerLiter distancePerLiter) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    public Sonata(final double tripDistance, final double distancePerLiter) {
        this(new TripDistance(tripDistance), new DistancePerLiter(distancePerLiter));
    }

    public Sonata(final double tripDistance) {
        this(tripDistance, DISTANCE_PER_LITER);
    }

    @Override
    protected double getDistancePerLiter() {
        return distancePerLiter.getValue();
    }

    @Override
    protected double getTripDistance() {
        return tripDistance.getValue();
    }

    @Override
    public String getName() {
        return "Sonata";
    }
}
