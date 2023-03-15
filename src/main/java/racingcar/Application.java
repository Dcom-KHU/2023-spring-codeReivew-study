package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> cars;
    private final int maxTurnCount;

    public Application(String[] carNames, int maxTurnCount) {
        checkDuplicateName(carNames);
        checkTurnValid(maxTurnCount);

        cars = new ArrayList<>();
        this.maxTurnCount = maxTurnCount;
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private void checkDuplicateName(String[] carNamesArray) {
        Set<String> carNamesSet = new HashSet<>(Arrays.asList(carNamesArray));
        if (carNamesSet.size() != carNamesArray.length) {
            throw new IllegalArgumentException("[Error] 중복된 이름이 있습니다.");
        }
    }

    private void checkTurnValid(int turn) {
        if (turn < 1) {
            throw new IllegalArgumentException("[Error] 1 이상의 숫자를 입력해주세요.");
        }
    }

    public static void main(String[] args) {
    }
}
