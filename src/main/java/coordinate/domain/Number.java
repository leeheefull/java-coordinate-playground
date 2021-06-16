package coordinate.domain;

import coordinate.exception.InputNotNumberException;

public class Number {
    private final int number;

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public Number(String number) {
        validate(number);
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String number) {
        if (!isNumber(number)) {
            throw new InputNotNumberException();
        }
    }

    private boolean isNumber(String number) {
        return number.matches(NUMBER_REGEX);
    }
}
