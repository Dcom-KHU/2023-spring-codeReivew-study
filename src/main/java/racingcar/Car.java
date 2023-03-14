package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

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
}
