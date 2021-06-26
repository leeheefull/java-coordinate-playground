package coordinate;

import coordinate.controller.CoordinateController;

public class CoordinateMain {
    public static void main(String[] args) {
        new CoordinateController().run();
    }
}

/*  예시
        (10,10)-(14,15)
        (10,10)-(14,15)-(20,8)
        (10,10)-(22,10)-(22,18)-(10,18)
 */