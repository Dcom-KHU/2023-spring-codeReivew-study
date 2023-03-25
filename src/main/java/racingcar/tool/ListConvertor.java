package racingcar.tool;

import racingcar.game.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ListConvertor {

    public static String joinCarsName(String delimiter, List<Car> cars) {
        List<String> names = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(delimiter, names);
    }

}
