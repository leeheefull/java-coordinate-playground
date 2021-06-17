package coordinate.domain;

import coordinate.exception.InputNotRectangleException;

public class Rectangle extends Square {

    public Rectangle(String rectangleInfo) {
        super(rectangleInfo);
        validate();
    }

    // 구현 중
    public int getArea() {
        return 0;
    }

    private void validate() {
        if (!isRectangle()) {
            throw new InputNotRectangleException();
        }
    }

    // 구현 중
    private boolean isRectangle() {
        return true;
    }
}
