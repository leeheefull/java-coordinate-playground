package rentCompany;

public class K5 extends Car {
    private final double distance;

    private static final double FUEL_EFFICIENCY = 13;
    private static final String NAME = "K5";

    public K5(double distance) {
        this.distance = distance;
    }

    @Override
    public double getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }

    @Override
    public double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
