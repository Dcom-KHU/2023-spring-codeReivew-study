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

    public String toString() {
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            bar.append("-");
        }
        return this.name + " : " + bar;
    }
}
