package racingcar.model;

import racingcar.dto.CarDTO;
import racingcar.dto.CarStatusDTO;
import racingcar.model.domain.Car;

import java.util.ArrayList;
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
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : racingCars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        findCarsAtPosition(maxPosition).forEach(car ->
                winnerNames.add(car.getName()));
        return winnerNames;
    }

    private List<Car> findCarsAtPosition(int position) {
        return racingCars.stream()
                .filter(car -> car.getPosition() == position)
                .collect(Collectors.toList());
    }
}
