package racingcar.game;

import racingcar.tool.PrintManager;

import java.util.List;

public class Round {
    private int currentRound;
    private final List<Car> cars;

    public Round(List<Car> cars) {
        this.currentRound = 1;
        this.cars = cars;
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    public void play() {
        moveAllCars();
        PrintManager.printAllCarsStatus(cars);
        this.currentRound += 1;
    }

    private void moveAllCars() {
        cars.forEach(Car::move);
    }

}
