package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int getPosition() {
		return this.position;
	}

	// 추가 기능 구현
	private void move() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			this.position += 1;
		}
	}

	public static void game(List<Car> cars) {
		int num = InputCheck.inputRound();
		for (int i = 0; i < num; i++) {
			System.out.println("실행 결과");
			// cars.forEach(Car::move);
			// cars.forEach(Car::printProgress);
			for (Car car : cars) {
				car.move();
				car.printProgress();
			}
			System.out.println();
		}
	}

	public static List<Car> make() {
		List<String> names = InputCheck.inputCarNames();
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public void printProgress() {
		String distance = new String(new char[this.position]).replace("\0", "-");
		System.out.printf("%s : %s%n", this.name, distance);
	}

	public static void printResult(List<Car> cars) {
		String winner = "";
		int winnerScore = -1;

		cars.sort((x, y) -> y.getPosition() - x.getPosition());
		for (Car car : cars) {
			if (car.getPosition() >= winnerScore) {
				winner += car.name + ", ";
				winnerScore = car.position;
			}
		}

		System.out.printf("최종 우승자 : %s", winner.substring(0, winner.length() - 2));
	}
}
