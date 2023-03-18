package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void forward() {
        if (pickNumberInRange(0, 9) >= 4) {
            this.position++;
        }
    }
}
