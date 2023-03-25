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

        outputView.printFinalWinner(getWinnerNames(cars));
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

    private static List<String> getWinnerNames(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                winnerNames.clear();
                max = car.getPosition();
            }
            if (car.getPosition() == max) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }
}
