package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		Set<String> carNamesSet = new HashSet<>(Arrays.asList(carNamesArray));
		if (carNamesSet.size() != carNamesArray.length) {
			throw new IllegalArgumentException("[Error] 중복된 이름이 있습니다.");
		}
	}

	public static void main(String[] args) {
	}
}
