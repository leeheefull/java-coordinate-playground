package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotNumberException;

public class Number {
    private final int number;

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 24;

    public Number(String numberInfo) throws InputIndexOutNumberException {
        validate(numberInfo);
        this.number = Integer.parseInt(numberInfo);
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(String numberInfo) throws InputIndexOutNumberException {
        if (!isNumber(numberInfo)) {
            throw new InputNotNumberException();
        }
        if (isOver(Integer.parseInt(numberInfo))) {
            throw new InputIndexOutNumberException();
        }
    }

    private boolean isNumber(String numberInfo) {
        return numberInfo.matches(NUMBER_REGEX);
    }

    private boolean isOver(int number) {
        return number < MIN_NUMBER || MAX_NUMBER < number;
    }
}
