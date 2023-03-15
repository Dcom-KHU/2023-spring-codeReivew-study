package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return String.format("%s : %s",this.name, getMoveString());
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.position += 1;
        }
    }

    private String getMoveString() {
        List<String> movePositionList = Arrays.stream(new String[this.position])
                .map(s -> "-")
                .collect(Collectors.toList());

        return String.join("", movePositionList);
    }
}
