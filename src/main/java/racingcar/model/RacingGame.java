package racingcar.model;

import racingcar.dto.CarDTO;
import racingcar.dto.CarStatusDTO;
import racingcar.model.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> racingCars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void enrollCars(List<String> carNames) {
        carNames.forEach(name -> racingCars.add(new Car(name)));
    }

    public List<CarStatusDTO> repeatMovingCars(int moveCount) {
        List<CarStatusDTO> carStatuses = new ArrayList<>();
        for (int count = 0; count < moveCount; count++)
            carStatuses.add(new CarStatusDTO(moveCars()));
        return carStatuses;
    }

    public List<CarDTO> moveCars() {
        racingCars.forEach(car -> car.move(numberGenerator.make()));
        return racingCars.stream()
                .map(Car::to)
                .collect(Collectors.toList());
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : racingCars) {
            if (findAnyHeadCar().compareTo(car) == 0)
                winners.add(car.getName());
        }
        return winners;
    }

    private Car findAnyHeadCar() {
        List<Car> sortedCars = new ArrayList<>(racingCars);
        Collections.sort(sortedCars); // Car 클래스의 compareTo()로 인해 position에 따라 많이 전진한 순대로 정렬
        return sortedCars.get(0);
    }
}