package tools;

import camp.nextstep.edu.missionutils.Console;

public class InputTool {
	public static String[] getCarNames() {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = Console.readLine();
		String[] cars = userInput.split(",");
		try {
			ValidationTool.checkValidNames(cars);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getCarNames();
		}
		return cars;
	}

	public static int getMaxMoves() {

		System.out.println("시도할 회수는 몇회인가요?");
		String userInput = Console.readLine();
		try {
			ValidationTool.checkValidMoves(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getMaxMoves();
		}
		return Integer.parseInt(userInput);
	}
}
