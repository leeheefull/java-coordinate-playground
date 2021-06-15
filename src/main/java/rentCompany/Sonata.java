package rentCompany;

public class Sonata extends Car {
    private final double distance;

    private static final double FUEL_EFFICIENCY = 10;
    private static final String NAME = "Sonata";

    public Sonata(double distance) {
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
