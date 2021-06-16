package rentCompany;

import java.util.Arrays;

public enum Car {
    SONATA("Sonata", 10),
    AVANTE("Avante", 15),
    K5("K5", 13);

    private final String name;
    private final int fuelEfficiency;

    private static final String COLON = " : ";
    private static final String LITER = "리터";

    Car(String name, int fuelEfficiency) {
        this.name = name;
        this.fuelEfficiency = fuelEfficiency;
    }

    public static Car of(String inputName) {
        return Arrays.stream(values())
                .filter(car -> car.name.equals(inputName))
                .findFirst()
                .get();
    }

    public String getName() {
        return this.name;
    }

    public double getFuelEfficiency() {
        return this.fuelEfficiency;
    }

    public double getChargeQuantity(int distance) {
        return distance / getFuelEfficiency();
    }

    public String print(int distance) {
        return name + COLON + (int) getChargeQuantity(distance) + LITER;
    }
}
