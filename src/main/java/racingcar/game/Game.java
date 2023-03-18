package racingcar.game;

import racingcar.tool.PrintManager;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> carList;
    private final int totalRound;

    public Game(List<Car> carList, int totalRound) {
        this.carList = carList;
        this.totalRound = totalRound;
    }

    public void start() {
        Round round = new Round(carList);

        PrintManager.printGameResultHead();
        while (round.getCurrentRound() <= totalRound) {
            round.play();
        }

        List<Car> winnerList = findWinners();
        PrintManager.printWinnersName(winnerList);
    }

    private List<Car> findWinners() {
        if (carList.size() == 0) {
            return Collections.emptyList();
        }

        int maxPosition = carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
