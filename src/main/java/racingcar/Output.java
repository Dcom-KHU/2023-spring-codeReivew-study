package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Output {
	public static void printProcedure(List<Car> carList) {
		System.out.println("실행 결과");
		for (Car car : carList) {
			String distance = new String(new char[car.getPosition()]).replace("\0", "-");
			System.out.printf("%s : %s%n", car.getName(), distance);
		}
		System.out.println();
	}

	static void printResult(List<Car> carList) {
		List<String> winner = new ArrayList<>();
		int maxValue = findMaxValue(carList);

		for (Car car : carList) {
			if (car.getPosition() < maxValue) {
				break;
			}
			winner.add(car.getName());
		}

		System.out.printf("최종 우승자 : %s", String.join(", ", winner));
	}

	private static int findMaxValue(List<Car> carList) {
		carList.sort((x, y) -> y.getPosition() - x.getPosition());
		return carList.get(0).getPosition();
	}
}
