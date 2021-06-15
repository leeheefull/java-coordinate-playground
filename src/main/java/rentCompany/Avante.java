package rentCompany;

public class Avante extends Car {
    private final double distance;

    private static final double FUEL_EFFICIENCY = 15;
    private static final String NAME = "Avante";

    public Avante(double distance) {
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
