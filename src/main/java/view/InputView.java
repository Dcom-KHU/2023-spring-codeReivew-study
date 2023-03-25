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
                String[] carNames = getCarNamesStringArray(carString);
                return getCarNamesCarList(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] getCarNamesStringArray(String carString) {
        InputValidator.validateSplit(carString);
        String[] carNames = carString.split(",");
        InputValidator.validateEmpty(carNames);
        return carNames;
    }

    private List<Car> getCarNamesCarList(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName :
                carNames) {
            cars.add(new Car(carName));
        }
        InputValidator.validateCarNames(cars);
        return cars;
    }

    public int getTrial() {
        while (true) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                String trial = Console.readLine();
                InputValidator.validateTrial(trial);
                return Integer.parseInt(trial);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
