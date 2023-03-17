package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    private final InputView inputView = new InputView();
    private static final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        enrollCarToRace();
    }

    public void enrollCarToRace() {
        List<String> carNames = inputView.inputCarNames();
        racingGame.enrollCars(carNames);
    }
}
