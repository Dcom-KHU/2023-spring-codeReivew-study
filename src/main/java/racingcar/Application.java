package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = InputUtils.getInstance().getCarListFromInput();
        int totalRound = InputUtils.getInstance().getTotalRoundFromInput();

        playAllRounds(totalRound, carList);

        printWinners(carList);
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
        carList.forEach(Car::move);
    }

    private static void printAllCarsStatus(List<Car> carList) {
        carList.forEach(System.out::println);
        System.out.println();
    }

    private static void printWinners(List<Car> carList) {
        System.out.printf("최종 우승자 : %s", getWinnersString(carList));
    }

    private static String getWinnersString(List<Car> carList) {
        List<String> winnerNameList = findWinners(carList).stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", winnerNameList);
    }

    private static List<Car> findWinners(List<Car> carList) {
        if (carList.size() == 0) {
            return Collections.emptyList();
        }

        int maxPosition = carList.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .get();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
