package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public List<String> receiveCarNames() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            List<String> carNames = Arrays.asList(readLine().split(","));
            try {
                validateCarNames(carNames);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                continue;
            }
            return carNames;
        }
    }

    private void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public int receiveAttemptNumber() {
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String attemptNumber = readLine();
            try {
                validateAttemptNumber(attemptNumber);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                continue;
            }
            return Integer.parseInt(attemptNumber);
        }
    }

    private void validateAttemptNumber(String attemptNumber) {
        if (!Pattern.matches("^[0-9]+$", attemptNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
