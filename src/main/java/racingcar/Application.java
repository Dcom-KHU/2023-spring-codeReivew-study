package racingcar;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Car> cars = Car.make();
		Car.game(cars);
		Car.printResult(cars);
	}
}
