package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

	private static final String CAR_NAME_DELIMITER = ",";
	private final List<Car> cars;

	public Application(String carNames) {
		cars = new ArrayList<>();
		String[] carNamesArray = carNames.split(CAR_NAME_DELIMITER);
		for (String carName : carNamesArray) {
			cars.add(new Car(carName));
		}
	}

	public static void main(String[] args) {
	}
}
