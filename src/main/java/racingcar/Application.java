package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        game.initiateGame();
    }
}

class Game{
    private int currentMove;
    private int maxMove;
    private Car[] cars;
    Game(){

    }
    /*
    public void printCars(){
        for(Car car : cars){
            System.out.println(car.getName());
        }
    }*/
    public void initiateGame(){

        String[] carNames = inputCarNames();
        cars = new Car[carNames.length];
        for(int index = 0; index < carNames.length; index++){
            cars[index] = new Car(carNames[index]);
        }
        //printCars();
    }
    public static String[] inputCarNames(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        String[] cars = userInput.split(",");
        try{
            checkValidNames(cars);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputCarNames();
        }
        return cars;
    }
    public static void checkValidNames(String[] cars) {

        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다.");
            }
        }
    }
}