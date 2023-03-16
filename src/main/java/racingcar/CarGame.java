package racingcar;

import view.InputView;

import java.util.List;

public class CarGame {
    private final InputView inputView;

    public CarGame() {
        this.inputView = new InputView();
    }

    public void start() {
        List<Car> cars = inputView.getCars();
    }
}
