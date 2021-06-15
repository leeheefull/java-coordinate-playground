package rentCompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {
    private final List<Car> cars = new ArrayList<>();

    private static final String COLON = " : ";
    private static final String LITER = "리터";
    private static final String LINE_BREAK = "\n";

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String generateReport() {
        return this.cars.stream()
                .map(car -> car.getName() + COLON + (int) car.getChargeQuantity() + LITER)
                .collect(Collectors.joining(LINE_BREAK));
    }
}
