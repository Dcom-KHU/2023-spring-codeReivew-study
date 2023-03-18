package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public List<String> receiveCarNames() {
        List<String> carNames = Arrays.asList(readLine().split(","));
        return carNames;
    }
}
