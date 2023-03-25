package view;

import racingcar.Car;

import java.util.List;

public class OutputView {
    public void printInit() {
        System.out.println("실행 결과");
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printFinalWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
