package racingcar;

import java.util.List;

public class OutputView {
    public void printExecutionResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
