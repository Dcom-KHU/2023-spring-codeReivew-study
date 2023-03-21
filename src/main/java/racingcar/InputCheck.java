package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public final class InputCheck {

	public static List<String> inputCarNames() {
		while (true) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
			List<String> names = new ArrayList<>(Arrays.asList(Console.readLine().split(",")));
			try {
				iterateCars(names);
				// names.forEach(InputCheck::stringCheck);
				return names;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// public static void stringCheck(String name) {
	// 	if (name.length() == 0 || name.length() > 5) {
	// 		throw new IllegalArgumentException("[ERROR] 이름은 1~5자 사이로 작성하라.");
	// 	}
	// }

	public static void iterateCars(List<String> names) {

		for (String name : names) {
			if (name.length() > 5) {
				throw new IllegalArgumentException();
			}
		}
	}

	public static int inputRound() {
		while (true) {
			System.out.println("시도할 회수는 몇회인가요?");
			try {
				String input = Console.readLine();
				match(input);
				return Integer.parseInt(input);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 시도 횟수는 자연수인 숫자여야 한다.");
			}
		}
	}

	public static void match(String input) {
		String pattern = "^[0-9]+$";
		if (!Pattern.matches(pattern, input)) {
			throw new IllegalArgumentException();
		}
	}
}
