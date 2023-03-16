package view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

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
        String[] carNames = inputValidator.validateSplit(carString);
        inputValidator.validateEmpty(carNames);
        return carNames;
    }

    private List<Car> validateCarNames(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName :
                carNames) {
            cars.add(new Car(carName));
        }
        inputValidator.validateCarNames(cars);
        return cars;
    }

    public Integer getTrial() {
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                String trial = Console.readLine();
                return inputValidator.validateTrial(trial);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
