package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import com.sun.org.apache.xpath.internal.operations.Bool;

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

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public static List<Car> getCarList(String input) {
        List<Car> carList = new ArrayList<>();
        List<String> inputList = new ArrayList(Arrays.asList(input.split(",")));

        for (String s : inputList) {
            fiveValidate(s);
            Car car = new Car(s);
            carList.add(car);
        }
        return carList;
    }

    public static void fiveValidate(String s) {
        if (s.length() > 5)
            throw new IllegalArgumentException("[Error] Car Name is over 5 letters");
    }

    public static Integer getGameCount(String input) throws IllegalArgumentException {
        Integer intInput;
        try {
            intInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error] Game Count must integer type");
        }
        return intInput;
    }

    public static void playGame(List<Car> carList, Integer count) {
        for (int i = 0; i < count; i++) {
            playOneGame(carList);
        }
    }

    public static void playOneGame(List<Car> carList){
        for (Car c : carList) {
            System.out.println();
            System.out.print(c.getName() + " : ");
            if (Randoms.pickNumberInRange(0, 9) > 4) {
                c.position = c.position + 1;
            }
            for (int j = 0; j < c.position; j++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    public static void getWinner(List<Car> carList) {
        System.out.println();
        System.out.print("Winner : ");
        Integer maxPosition = 0;
        for (Car c : carList) {
            if (c.position > maxPosition)
                maxPosition = c.position;
        }
        System.out.println((printWinner(carList,maxPosition)));
    }

    public static String printWinner(List<Car> carList, Integer maxPosition) {
        String print = "";
        for(Car c : carList){
            if(c.position == maxPosition){
                print = print + c.getName() + ", ";
            }
        }

        return print.substring(0,print.length()-2);
    }
}
