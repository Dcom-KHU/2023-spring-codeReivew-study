package racingcar.controller;

import racingcar.dto.CarStatusDTO;
import racingcar.model.RacingGame;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    private final InputView inputView = new InputView();
    private final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        enrollCarToRace();
        moveCarsByCount();
    }

    public void enrollCarToRace() {
        List<String> carNames = inputView.inputCarNames();
        racingGame.enrollCars(carNames);
    }

    public void moveCarsByCount() {
        int moveCount = inputView.inputMoveCount();
        // moveCount만큼 반복 이동
        List<CarStatusDTO> carStatuses = racingGame.repeatMovingCars(moveCount);
    }
}
