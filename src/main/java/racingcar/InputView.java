package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public List<String> receiveCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            List<String> carNames = Arrays.asList(readLine().split(","));
            try {
                validate(carNames);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                continue;
            }
            return carNames;
        }
    }

    private void validate(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
