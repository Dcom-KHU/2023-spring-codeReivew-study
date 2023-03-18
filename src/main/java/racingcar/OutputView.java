package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printExecutionResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public void printPreface() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printFinalWinner(List<Car> cars) {
        List<String> finalWinner = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                finalWinner.clear();
                max = car.getPosition();
            }
            if (car.getPosition() == max) {
                finalWinner.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", finalWinner));
    }
}
