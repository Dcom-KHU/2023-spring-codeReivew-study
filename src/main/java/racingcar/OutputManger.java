package racingcar;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class OutputManger {
    public void printGetCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printGetAttemptNum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printRunResultMessage() {
        System.out.println("실행 결과\n");
    }

    public void printSimulationResult(List<Car> cars) {
        for (Car car : cars) {
            printCarInfo(car);
        }
        System.out.println();
    }

    public void printCarInfo(Car car) {
        System.out.print(car.getName() + " : ");
        for(int i=0; i<car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for(int i=0; i<winners.size()-1; i++) {
            System.out.print(winners.get(i).getName() + ", ");
        }
        System.out.println(winners.get(winners.size()-1).getName());
    }

}
