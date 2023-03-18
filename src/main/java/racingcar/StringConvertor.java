package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConvertor {

    public static List<Car> convertIntoCarList(String carNames) throws IllegalArgumentException {
        return Arrays.stream(carNames.split(","))
                .map(String::trim)
                .map(Car::createCar)
                .collect(Collectors.toList());
    }

    public static Integer convertIntoNaturalNumber(String targetString) throws IllegalArgumentException {
        try {
            int number = Integer.parseInt(targetString);

            if (number < 1) {
                throw new NumberFormatException();
            }

            return number;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("자연수가 아닌 값은 입력할 수 없습니다.");
        }
    }
}
