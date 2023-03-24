package tools;

public class ValidationTool {

	public static void checkValidNames(String[] cars) {

		for (String car : cars) {
			if (car.length() > 5) {
				throw new IllegalArgumentException("[ERROR] 이름은 5자 이하여야 합니다.");
			}
		}
	}

	public static void checkValidMoves(String userInput) {

		int inputMoves;
		try {
			inputMoves = Integer.parseInt(userInput);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
		}
		if (inputMoves <= 0) {
			throw new IllegalArgumentException("[ERROR] 시도 횟수는 양의 정수여야 한다.");
		}
	}
}
