package racingcar;

import java.util.ArrayList;
import java.util.List;

import utility.InputCheck;
import utility.Output;
import utility.Sort;

public class Game {
	private List<Car> cars = new ArrayList<>();

	private void make() {
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

	public List<String> findWinners() {
		List<String> winner = new ArrayList<>();
		List<Car> sortedCars = Sort.sortByPosition(this.cars);
		int winnerScore = sortedCars.get(0).getPosition();
		for (Car car : sortedCars) {
			if (car.getPosition() < winnerScore) {
				break;
			}
			winner.add(car.getName());
		}

		return winner;
	}

	public void start() {
		make();
		run();
		Output.printResult(findWinners());
	}
}
