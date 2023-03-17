package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        List<Car> carList = racingcar.Car.getCarList(input);

        Integer count = racingcar.Car.getGameCount(Console.readLine());

        racingcar.Car.playGame(carList, count);

        racingcar.Car.getWinner(carList);
    }
}
