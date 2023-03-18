package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class PrintManager {

    public static void printCarNameInputDescription() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printTotalRoundInputDescription() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printAllCarsStatus(List<Car> carList) {
        carList.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinnersName(List<Car> carList) {
        String winnersName = getWinnersString(carList);

        System.out.printf("최종 우승자 : %s", winnersName);
    }

    private static String getWinnersString(List<Car> carList) {
        List<String> winnerNameList = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", winnerNameList);
    }

    public static void printGameResultHead() {
        System.out.println("\n실행 결과");
    }

    public static void printErrorMessage(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }
}
