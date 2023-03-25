package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String[] getCar() {
        String input = Console.readLine();
        return input.split(",");
    }
    public int getAttemptNum() {
        String attemptNum = Console.readLine();
        return Integer.parseInt(attemptNum);
    }

}
