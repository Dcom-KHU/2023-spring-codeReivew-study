package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void move(){
        if (Randoms.pickNumberInRange(0, 9) >= 4){
            this.position += 1;
        }
    }
    public static void game(Arraylist<Car> cars){
        int num = Integer.parseInt(Console.readLine());
        for (Car car : carlist){
            for (int i = 0; i < num; i++){
                car.move();
            }
        }
    }
}
