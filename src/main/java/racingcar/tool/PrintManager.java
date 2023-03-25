package racingcar.tool;

import racingcar.game.Car;

import java.util.List;

public class PrintManager {

    private PrintManager() {}

    public static void printCarNameInputDescription() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTotalRoundInputDescription() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printAllCarsStatus(List<Car> cars) {
        cars.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningCarsName(List<Car> winningCars) {
        String winningCarsName = ListConvertor.joinCarsName(", ", winningCars);

        System.out.printf("최종 우승자 : %s", winningCarsName);
    }

    public static void printGameResultHead() {
        System.out.println("\n실행 결과");
    }

    public static void printErrorMessage(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }
}
