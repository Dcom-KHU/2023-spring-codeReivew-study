package view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Car> getCars() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
                String carString = Console.readLine();
                String[] carNames = validateCarString(carString);
                return validateCarNames(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] validateCarString(String carString) {
        String[] carNames = InputValidator.validateSplit(carString);
        InputValidator.validateEmpty(carNames);
        return carNames;
    }

    private List<Car> validateCarNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName :
                carNames) {
            cars.add(new Car(carName));
        }
        InputValidator.validateCarNames(cars);
        return cars;
    }

    public Integer getTrial() {
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                String trial = Console.readLine();
                return InputValidator.validateTrial(trial);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
