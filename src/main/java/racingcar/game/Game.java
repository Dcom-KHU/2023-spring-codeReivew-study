package racingcar.game;

import racingcar.tool.PrintManager;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Car> cars;
    private final int totalRound;

    public Game(List<Car> cars, int totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
    }

    public void start() {
        Round round = new Round(cars);

        PrintManager.printGameResultHead();
        while (round.getCurrentRound() <= totalRound) {
            round.play();
        }

        List<Car> winningCars = findWinningCars();
        PrintManager.printWinningCarsName(winningCars);
    }

    private List<Car> findWinningCars() {
        if (cars.size() == 0) {
            return Collections.emptyList();
        }

        int maxPosition = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
