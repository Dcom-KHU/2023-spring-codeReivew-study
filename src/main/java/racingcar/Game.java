package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static List<Car> make() {
		List<String> names = InputCheck.inputCarNames();
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private static void run(List<Car> cars) {
		int num = InputCheck.inputRound();
		for (int i = 0; i < num; i++) {
			cars.forEach(Car::move);
			Output.printProcedure(cars);
			System.out.println();
		}
	}

	public static void start(List<Car> cars) {
		run(cars);
		Output.printResult(cars);
	}
}
