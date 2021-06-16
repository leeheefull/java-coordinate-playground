package rentCompanyTest;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RentCompany {
    private final Cars cars = new Cars();

    private static final String LINE_BREAK = "\n";

    public void addReport(String name, int distance) {
        this.cars.addCar(name, distance);
    }

    public String getReports() {
        return IntStream.range(0, this.cars.size())
                .mapToObj(i -> Car.of(this.cars.getCarNames().get(i)).print(this.cars.getCarDistances().get(i)))
                .collect(Collectors.joining(LINE_BREAK));
    }
}
