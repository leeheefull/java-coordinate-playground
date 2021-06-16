package coordinate.domain;

import coordinate.exception.InputNotNumberException;

public class Number {
    private final int number;

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public Number(String numberInfo) {
        validate(numberInfo);
        this.number = Integer.parseInt(numberInfo);
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return this.number + "";
    }

    private void validate(String numberInfo) {
        if (!isNumber(numberInfo)) {
            throw new InputNotNumberException();
        }
    }

    private boolean isNumber(String numberInfo) {
        return numberInfo.matches(NUMBER_REGEX);
    }
}
