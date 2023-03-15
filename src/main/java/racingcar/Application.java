package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        List<Car> cars = getCars();
    }

    public static List<Car> getCars() {
        String carName = Console.readLine();
        String[] carNames = carName.split(",");

        List<Car> Cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            Cars.add(car);
        }
        return Cars;
    }
}
