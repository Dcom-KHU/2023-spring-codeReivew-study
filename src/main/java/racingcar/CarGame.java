package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;

import java.util.List;

public class CarGame {
    private final InputView inputView;

    public CarGame() {
        this.inputView = new InputView();
    }

    public void start() {
        List<Car> cars = inputView.getCars();
        Integer trial = inputView.getTrial();
        startGame(cars, trial);
    }

    private void startGame(List<Car> cars, Integer trial) {
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                go(car);
            }
        }
    }

    private void go(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
    }
}
