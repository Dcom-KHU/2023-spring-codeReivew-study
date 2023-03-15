package racingcar;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		ArrayList<Car> cars = Car.make();
		Car.game(cars);
		Car.printResult(cars);
	}
}
