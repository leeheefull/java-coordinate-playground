package rentCompanyTest;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Cars {
    private final List<String> carNames = new ArrayList<>();
    private final List<Integer> carDistances = new ArrayList<>();

    public void addCar(String name, int distance) {
        this.carNames.add(name);
        this.carDistances.add(distance);
        validate();
    }

    public List<String> getCarNames() {
        return this.carNames;
    }

    public List<Integer> getCarDistances() {
        return this.carDistances;
    }

    public int size() {
        return this.carNames.size();
    }

    private void validate() {
        if (isEqual()) {
            throw new InputMismatchException();
        }
    }

    private boolean isEqual() {
        return this.carNames.size() != this.carDistances.size();
    }
}
