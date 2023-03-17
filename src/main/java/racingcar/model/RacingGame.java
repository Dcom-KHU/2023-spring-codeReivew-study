package racingcar.model;

import racingcar.model.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> racingCars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
    public void enrollCars(List<String> carNames) {
        carNames.forEach(name -> racingCars.add(new Car(name)));
    }
}
