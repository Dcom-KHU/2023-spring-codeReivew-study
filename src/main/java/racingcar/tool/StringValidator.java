package racingcar.tool;

public class StringValidator {

    private StringValidator() {}

    public static void cannotUseCarName(String carName) throws IllegalArgumentException {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        } else if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자리입니다. 불가능한 이름: " + carName);
        }
    }
}
