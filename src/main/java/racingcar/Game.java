package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Car> carList = new ArrayList<>();

	public void make() {
		List<String> names = InputCheck.inputCarNames();
		for (String name : names) {
			this.carList.add(new Car(name));
		}
	}

	private void run() {
		int num = InputCheck.inputRound();
		for (int i = 0; i < num; i++) {
			this.carList.forEach(Car::move);
			Output.printProcedure(this.carList);
		}
	}

	public void start() {
		run();
		Output.printResult(this.carList);
	}
}
