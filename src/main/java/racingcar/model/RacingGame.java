package racingcar.model;

import racingcar.dto.CarDTO;
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

    public List<CarDTO> moveCars() {
        racingCars.forEach(car -> car.move(numberGenerator.make()));
        return racingCars.stream()
                .map(Car::to)
                .collect(Collectors.toList());
    }
}
