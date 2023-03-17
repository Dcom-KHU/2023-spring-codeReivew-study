package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    private final InputView inputView = new InputView();

    public void run() {
        enrollCar();
    }

    public void enrollCar() {
        List<String> carNames = inputView.inputCarNames();
        System.out.println(carNames);
    }
}
