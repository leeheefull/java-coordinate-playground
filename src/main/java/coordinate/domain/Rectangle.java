package coordinate.domain;

import coordinate.exception.InputIndexOutNumberException;
import coordinate.exception.InputNotRectangleException;

public class Rectangle extends Square {

    public Rectangle(String rectangleInfo) throws InputIndexOutNumberException {
        super(rectangleInfo);
        validate();
    }

    public double getArea() {
        double lineLength1 = this.getLines().get(0).getLength();
        double lineLength2 = this.getLines().stream()
                .map(Line::getLength)
                .filter(l -> l != lineLength1)
                .findAny()
                .get();
        return lineLength1 * lineLength2;
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
