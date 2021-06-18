package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotNumberException;

public class Number {
    private final int number;

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public Number(String numberInfo) throws InputIndexOutNumberException {
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

    private void validate(String numberInfo) throws InputIndexOutNumberException {
        if (!isNumber(numberInfo)) {
            throw new InputNotNumberException();
        }
        if (isOver(numberInfo)) {
            throw new InputIndexOutNumberException();
        }
    }

    private boolean isNumber(String numberInfo) {
        return numberInfo.matches(NUMBER_REGEX);
    }

    private boolean isOver(String numberInfo) {
        int number = Integer.parseInt(numberInfo);
        return number < 1 || 24 < number;
    }
}
