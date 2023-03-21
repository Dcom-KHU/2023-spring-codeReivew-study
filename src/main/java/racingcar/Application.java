package racingcar;

import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<Car> cars = Game.make();
		Game.start(cars);
	}
}
