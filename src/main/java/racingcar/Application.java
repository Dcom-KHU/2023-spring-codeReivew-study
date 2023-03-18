package racingcar;

import racingcar.game.Car;
import racingcar.game.Game;
import racingcar.tool.InputUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = InputUtils.getCarListFromInput();
        int totalRound = InputUtils.getTotalRoundFromInput();
        Game game = new Game(carList, totalRound);

        game.start();
    }
}
