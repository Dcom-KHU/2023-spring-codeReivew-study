package racingcar;

import java.util.List;

public class Round {
    private int currentRound;
    private final List<Car> carList;

    public Round(List<Car> carList) {
        this.currentRound = 1;
        this.carList = carList;
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    public void play() {
        moveAllCars();
        PrintManager.printAllCarsStatus(carList);
        this.currentRound += 1;
    }

    private void moveAllCars() {
        carList.forEach(Car::move);
    }

}
