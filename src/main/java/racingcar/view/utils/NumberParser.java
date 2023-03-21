package racingcar.view.utils;

public class NumberParser {
    private NumberParser() {}

    public static int parseDigit(String value) {
        int number = parseInteger(value); // 입력값을 정수로 변환
        if (number <= 0)
            throw new IllegalArgumentException("입력값이 자연수가 아닙니다.");

        return number;
    }

    public static int parseInteger(String value) {
        try {
            return Integer.parseInt(value); // 숫자형의 문자열을 인자 값으로 받으면 십진수의 Integer 형으로 변환해줌
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }
}
