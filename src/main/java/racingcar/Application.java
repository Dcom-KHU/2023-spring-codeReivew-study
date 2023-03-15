package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = getCarListFromInput();
    }

    private static List<Car> getCarListFromInput() {
        while (true) {
            printCarNameInputDescription();

            String carNames = Console.readLine();
            try {
                checkCarNameInputAvailable(carNames);

                return convertCarNamesIntoCarList(carNames);
            } catch (IllegalArgumentException exception) {
                System.out.println("[Error] " + exception.getMessage());
            }
        }
    }

    private static List<Car> convertCarNamesIntoCarList(String carNames) throws IllegalArgumentException {
        return Arrays.stream(carNames.split(","))
                .map(Application::createCar)
                .collect(Collectors.toList());
    }

    private static Car createCar(String carName) throws IllegalArgumentException {
        checkCarNameAvailable(carName);

        return new Car(carName);
    }

    private static void checkCarNameAvailable(String carName) throws IllegalArgumentException {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자리입니다. 불가능한 이름: " + carName);
        }
    }

    private static void checkCarNameInputAvailable(String carNameInput) throws IllegalArgumentException {
        if (carNameInput.endsWith(",")) {
            throw new IllegalArgumentException("쉼표(,)로 끝난 올바르지 않은 입력입니다.");
        }
    }

    private static void printCarNameInputDescription() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
