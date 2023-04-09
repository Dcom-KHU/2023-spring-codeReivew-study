package utility;

import java.util.List;

import racingcar.Car;

public class Sort {
	public static List<Car> sortByPosition(List<Car> cars) {
		cars.sort((x, y) -> y.getPosition() - x.getPosition());
		return cars;
	}
}
