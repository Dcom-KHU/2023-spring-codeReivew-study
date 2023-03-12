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
		checkDuplicateName(carNamesArray);
		for (String carName : carNamesArray) {
			cars.add(new Car(carName));
		}
	}


	private void checkDuplicateName(String[] carNamesArray){
		for (int i = 0; i < carNamesArray.length; i++) {
			for (int j = i + 1; j < carNamesArray.length; j++) {
				if (carNamesArray[i].equals(carNamesArray[j])) {
					throw new IllegalArgumentException("[Error] 중복된 이름이 있습니다.");
				}
			}
		}
	}

	public static void main(String[] args) {
	}
}
