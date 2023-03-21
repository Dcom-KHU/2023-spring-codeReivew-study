package racingcar.view.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatParser {
    private FormatParser() {
    }

    public static List<String> split(String line, String delimiter) {
        validateWrongFormat(line);
        String[] values = line.split(delimiter); // 문자열 배열
        List<String> parsedValue = Arrays.stream(values)
                .map(String::trim) // trim: 문자열 공백 제거
                .collect(Collectors.toList());
        validateEmpty(parsedValue);
        return parsedValue;
    }
    private static void validateWrongFormat(String line) {
        if (hasWrongFormat(line)) {
            throw new IllegalArgumentException("입력값의 형식이 잘못되었습니다.");
        }
    }

    private static boolean hasWrongFormat(String line) {
        if (line.isEmpty()) {
            return true;
        }
        return line.startsWith(",") || line.endsWith(",");
    }

    private static void validateEmpty(List<String> values) {
        if (hasEmptyValue(values))
            throw new IllegalArgumentException("입력값에 빈 문자열이 있습니다.");
    }

    private static boolean hasEmptyValue(List<String> values) {
        return values.stream()
                .anyMatch(String::isEmpty); // anyMatch(): 최소한 한 개의 요소가 주어진 조건에 만족하는지 조사하는 함수 & '::': 메소드 레퍼런스. 람다식을 더욱 간결하게 해준다.
    }

    public static String join(List<String> values, String delimiter) {
        return String.join(delimiter, values);
    }

    public static String make(int count, String unit) {
        String units = "";
        for (int i = 0; i < count; i++)
            units = units + unit.charAt(i);
        return units;
    }
}
