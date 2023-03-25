package view;

import racingcar.Car;

import java.util.List;
import java.util.regex.PatternSyntaxException;

public class InputValidator {
    public static void validateSplit(String carString) {
        try {
            String[] split = carString.split(",");
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 쉼표를 기준으로 구분되어야 한다.");
        }
    }

    public static void validateCarNames(List<Car> cars) {
        for (Car car : cars) {
            String carName = car.getName();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능하다.");
            }
        }
    }

    public static void validateEmpty(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] 자동차는 1대 이상 입력 되어야 한다.");
        }
        for (String carName :
                carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 빈칸일 수 없다.");
            }
        }
    }

    public static void validateTrial(String trial) {
        try {
            int trialNum = Integer.parseInt(trial);
            if (trialNum < 0) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 음수일 수 없다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
    }
}
