package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    private List<Car> cars;
    private InputManager inputManager;
    private OutputManger outputManger;
    private int totalAttemptNum;


    public static void main(String[] args) {
        Application app = new Application();
        app.inputManager = new InputManager();
        app.outputManger = new OutputManger();
        app.run();
    }

    public void run() {
        getInfo();
        simulation();
        finishGame();
    }

    private void getInfo() {
        cars = new ArrayList<>();

        outputManger.printGetCarName();
        String[] carName = inputManager.getCar();

        for(String name : carName) {
            cars.add(new Car(name));
        }

        outputManger.printGetAttemptNum();
        this.totalAttemptNum = inputManager.getAttemptNum();

        outputManger.printRunResultMessage();
    }

    private void simulation() {

       for(int i=0; i<totalAttemptNum; i++) {
           for (Car car : cars) {
               car.CheckAdvance(car.GenerateRandomNumber());
           }
           outputManger.printSimulationResult(cars);
       }
    }

    private List<Car> calWinner() {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<Car>();

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private void finishGame() {
        outputManger.printWinner(calWinner());
    }

}