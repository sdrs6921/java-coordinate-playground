package rentcar.domain.car;

import rentcar.domain.car.vo.DistancePerLiter;
import rentcar.domain.car.vo.TripDistance;

public class K5 extends Car {

    private static final double DISTANCE_PER_LITER = 13;

    private final TripDistance tripDistance;
    private final DistancePerLiter distancePerLiter;

    public K5(final TripDistance tripDistance, final DistancePerLiter distancePerLiter) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    public K5(final double tripDistance, final double distancePerLiter) {
        this(new TripDistance(tripDistance), new DistancePerLiter(distancePerLiter));
    }

    public K5(final double tripDistance) {
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
        return "K5";
    }
}
