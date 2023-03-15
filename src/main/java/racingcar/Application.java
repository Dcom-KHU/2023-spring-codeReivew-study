package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        ArrayList<Car> cars = Car.make();
        Car.game(cars);
        Car.printResult(cars);
    }
}
