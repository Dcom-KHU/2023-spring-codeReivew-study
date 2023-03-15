package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = InputUtils.getInstance().getCarListFromInput();
        int totalRound = InputUtils.getInstance().getTotalRoundFromInput();

        playAllRounds(totalRound, carList);
    }

    private static void playAllRounds(int totalRound, List<Car> carList) {
        System.out.println("\n실행 결과");
        while (--totalRound >= 0) {
            playRound(carList);
        }
    }

    private static void playRound(List<Car> carList) {
        moveAllCars(carList);
        printAllCarsStatus(carList);
    }

    private static void moveAllCars(List<Car> carList) {
        carList.stream().forEach(Car::move);
    }

    private static void printAllCarsStatus(List<Car> carList) {
        carList.stream().forEach(System.out::println);
        System.out.println();
    }


}
