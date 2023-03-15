package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int moveRate = 20;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void randomlyGoForward() {
        if(Randoms.pickNumberInRange(0, 100) >= moveRate)
            position++;
    }
}
