package rentcar.domain.car;

import rentcar.domain.car.vo.DistancePerLiter;
import rentcar.domain.car.vo.TripDistance;

public class Avante extends Car{

    private static final double DISTANCE_PER_LITER = 15;

    private final TripDistance tripDistance;
    private final DistancePerLiter distancePerLiter;

    public Avante(final TripDistance tripDistance, final DistancePerLiter distancePerLiter) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    public Avante(final double tripDistance, final double distancePerLiter) {
        this(new TripDistance(tripDistance), new DistancePerLiter(distancePerLiter));
    }

    public Avante(final double tripDistance) {
        this(tripDistance, DISTANCE_PER_LITER);
    }

    @Override
    public double getDistancePerLiter() {
        return distancePerLiter.getValue();
    }

    @Override
    public double getTripDistance() {
        return tripDistance.getValue();
    }

    @Override
    public String getName() {
        return "Avante";
    }
}
