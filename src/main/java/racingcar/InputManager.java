package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final String CAR_NAME_DELIMITER = ",";

    public static String[] getCarNames(){
        String inputLine = Console.readLine();
        return inputLine.split(CAR_NAME_DELIMITER);
    }

    public static int getCount(){
        String inputLine = Console.readLine();
        try{
            int count = Integer.parseInt(inputLine);
            if(count < 1){
                throw new IllegalArgumentException("[Error] 1 이상의 숫자를 입력해주세요.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[Error]숫자를 입력해주세요.");
        }
    }
}
