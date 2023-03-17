package racingcar;

import static java.lang.Integer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGame {

    private static final String CAR_NAME_DELIMITER = ",";
    private InputManager inputManager;
    private OutputManager outputManager;
    private List<Car> cars;
    private int maxTurnCount;

    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        RacingGame game = new RacingGame(inputManager, outputManager);
        game.start();
    }

    public RacingGame(InputManager inputManager, OutputManager outputManager) {
        this.inputManager = inputManager;
        this.outputManager = outputManager;
    }

    public void start() {
        initGame();
        race();
        reward();
    }

    private void initGame() {
        outputManager.printCarNameInputMessage();
        String[] carNames = inputManager.getCarNames();
        checkDuplicateName(carNames);

        outputManager.printTurnInputMessage();
        int turn = inputManager.getCount();
        checkTurnValid(turn);


        int maxCarNameLen = -1;
        cars = new ArrayList<>();
        this.maxTurnCount = turn;
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
            maxCarNameLen = max(maxCarNameLen, carName.length());
        }

        outputManager.setMaxCarNameLen(maxCarNameLen);
    }

    private void race() {
        outputManager.printResultMessage();
        for (int i = 0; i < maxTurnCount; i++) {
            for (Car car : cars) {
                car.randomlyGoForward();
            }
            outputManager.printCarData(cars);
        }
    }

    private void reward() {
        List<Car> winnerCars = getWinnerCars();
        outputManager.printWinner(winnerCars);
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

    private List<Car> getWinnerCars() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
