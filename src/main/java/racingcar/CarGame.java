package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;
import view.OutputView;

import java.util.List;

public class CarGame {
    private final InputView inputView;
    private final OutputView outputView;

    public CarGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<Car> cars = inputView.getCars();
        Integer trial = inputView.getTrial();
        startGame(cars, trial);
    }

    private void startGame(List<Car> cars, Integer trial) {
        outputView.printInit();
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                goOrNot(car);
            }
            outputView.printResult(cars);
        }
    }

    private void goOrNot(Car car) {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            car.go();
        }
    }
}
