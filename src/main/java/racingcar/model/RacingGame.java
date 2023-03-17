package racingcar.model;

import racingcar.model.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final List<Car> racingCars = new ArrayList<>();

    public void enrollCars(List<String> carNames) {
        carNames.forEach(name -> racingCars.add(new Car(name)));
    }
}
