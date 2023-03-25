package racingcar.tool;

import camp.nextstep.edu.missionutils.Console;

import racingcar.game.Car;

import java.util.List;

public class InputUtils {

    public static List<Car> getCarListFromInput() {
        while (true) {
            PrintManager.printCarNameInputDescription();

            //for to split last comma, ' ' is going to be removed by trim func.
            String carNames = Console.readLine() + ' ';
            try {
                return StringConvertor.convertIntoCars(carNames);
            } catch (IllegalArgumentException exception) {
                PrintManager.printErrorMessage(exception.getMessage());
            }
        }
    }

    public static int getTotalRoundFromInput() {
        while (true) {
            PrintManager.printTotalRoundInputDescription();

            String roundInput = Console.readLine();
            try {
                return StringConvertor.convertIntoNaturalNumber(roundInput);
            } catch (IllegalArgumentException exception) {
                PrintManager.printErrorMessage(exception.getMessage());
            }
        }
    }

}
