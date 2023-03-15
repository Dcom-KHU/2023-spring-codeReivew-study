package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputUtils {
    private static InputUtils inputUtils;

    private InputUtils() {}

    public static InputUtils getInstance() {
        if (inputUtils == null) {
            inputUtils = new InputUtils();
        }
        return inputUtils;
    }

    public List<Car> getCarListFromInput() {
        while (true) {
            printCarNameInputDescription();

            String carNames = Console.readLine();
            try {
                checkCarNameInputAvailable(carNames);

                return convertCarNamesIntoCarList(carNames);
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }

    private void printCarNameInputDescription() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private void checkCarNameInputAvailable(String carNameInput) throws IllegalArgumentException {
        if (carNameInput.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(,)로 끝난 올바르지 않은 입력입니다.");
        }
    }

    private List<Car> convertCarNamesIntoCarList(String carNames) throws IllegalArgumentException {
        return Arrays.stream(carNames.split(","))
                .map(this::createCar)
                .collect(Collectors.toList());
    }

    private Car createCar(String carName) throws IllegalArgumentException {
        checkCarNameAvailable(carName);

        return new Car(carName);
    }

    private void checkCarNameAvailable(String carName) throws IllegalArgumentException {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자리입니다. 불가능한 이름: " + carName);
        }
    }

    public int getTotalRoundFromInput() {
        while (true) {
            printTotalRoundInputDescription();

            String roundInput = Console.readLine();
            try {
                int totalRound = convertRoundInputIntoRoundInteger(roundInput);

                checkTotalRoundAvailable(totalRound);

                return totalRound;
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }

    private void printTotalRoundInputDescription() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private Integer convertRoundInputIntoRoundInteger(String roundInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(roundInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("자연수가 아닌 값은 입력할 수 없습니다.");
        }
    }

    private void checkTotalRoundAvailable(int totalRound) throws IllegalArgumentException {
        if (totalRound < 1) {
            throw new IllegalArgumentException("자연수가 아닌 값은 입력할 수 없습니다.");
        }
    }
}
