package racingcar;

import java.util.List;

public class PrintManager {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTurnInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printCarData(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getDash(car.getPosition()));
        }
        System.out.println();
    }

    private String getDash(int position) {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < position; i++) {
            dash.append("-");
        }
        return dash.toString();
    }
}
