package racingcar;

import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static List<Car> getCarList(String input) {
        List<Car> carList = new ArrayList<>();
        List<String> inputList = new ArrayList(Arrays.asList(input.split(",")));

        for(String s : inputList) {
            fiveValidate(s);
            Car car = new Car(s);
            carList.add(car);
        }
        return carList;
    }

    public static void fiveValidate(String s) {
        if(s.length() > 5)
            throw new IllegalArgumentException("[Error] Car Name is over 5 letters");
    }
}
