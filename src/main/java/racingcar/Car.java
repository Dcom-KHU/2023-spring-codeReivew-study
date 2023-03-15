package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현

    public int getPosition() {
        return this.position;
    }

    public String toString() {
        return String.format("%s : %s",this.name, getMoveString());
    }

    public void move() {
        if (pickNumberInRange(0, 9) >= 4) {
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
