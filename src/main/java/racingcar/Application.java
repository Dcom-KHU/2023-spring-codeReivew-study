package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        List<Car> cars = initializeCars(inputView.receiveCarNames());
        int attemptNumber = inputView.receiveAttemptNumber();

        outputView.printPreface();
        for (int i = 0; i < attemptNumber; i++) {
            moveCars(cars);
            outputView.printExecutionResults(cars);
        }

        outputView.printFinalWinner(cars);
    }

    private static List<Car> initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.forward();
        }
    }
}
