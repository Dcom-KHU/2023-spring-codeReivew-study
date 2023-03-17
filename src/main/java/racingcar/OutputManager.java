package racingcar;

import java.util.List;

public class OutputManager {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTurnInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
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

    public void printWinner(List<Car> winnerCars) {
        System.out.print("최종 우승자 : ");
        for(Car winner : winnerCars){
            System.out.print(winner.getName());
            if(winner != winnerCars.get(winnerCars.size()-1))
                System.out.print(", ");
        }
        System.out.println();
    }
}