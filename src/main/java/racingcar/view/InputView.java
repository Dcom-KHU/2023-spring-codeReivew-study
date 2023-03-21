package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.utils.FormatParser;
import racingcar.view.utils.NumberParser;

import java.util.List;

public class InputView {
    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름들을 입력하세요. (이름은 쉼표(,)로 구분함)");
        String line = Console.readLine(); // 콘솔로부터 값 읽기
        return FormatParser.split(line, ","); // ',' 단위로 자른 공백 제거한 입력한 자동차 이름들의 목록
    }

    public int inputMoveCount() {
        System.out.println("몇 번 시도할지 입력하세요. (숫자)");
        String line = Console.readLine();
        return NumberParser.parseDigit(line); // 입력값을 정수로 변환
    }
}
