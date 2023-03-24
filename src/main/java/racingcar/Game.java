package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Car> cars = new ArrayList<>();

	public void make() {
		List<String> names = InputCheck.inputCarNames();
		for (String name : names) {
			this.cars.add(new Car(name));
		}
	}

	private void run() {
		int num = InputCheck.inputRound();
		for (int i = 0; i < num; i++) {
			this.cars.forEach(Car::move);
			Output.printProcedure(this.cars);
		}
	}

	public void start() {
		make();
		run();
		Output.printResult(this.cars);
	}
}
