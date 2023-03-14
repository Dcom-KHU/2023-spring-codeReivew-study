package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import net.bytebuddy.description.type.TypeList.Generic;

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
    public static void game(ArrayList<Car> cars){
        int num = Integer.parseInt(Console.readLine());
        for (Car car : cars){
            for (int i = 0; i < num; i++){
                car.move();
            }
        }
    }
    public static ArrayList<Car> make(){
        ArrayList<String> names = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
        ArrayList<Car> Cars = new ArrayList<Car>();
        for (String name : names){
            Cars.add(new Car(name));
        }

        return Cars;
    }
}
