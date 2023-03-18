package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_RATE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void randomlyGoForward() {
        if(Randoms.pickNumberInRange(0, 9) >= MOVE_RATE)
            position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
