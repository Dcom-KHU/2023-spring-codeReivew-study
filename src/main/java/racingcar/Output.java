package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Output {
	public static void printProcedure(List<Car> cars) {
		System.out.println("실행 결과");
		for (Car car : cars) {
			String distance = new String(new char[car.getPosition()]).replace("\0", "-");
			System.out.printf("%s : %s%n", car.getName(), distance);
		}
	}

	static void printResult(List<Car> cars) {
		List<String> winner = new ArrayList<>();
		int maxValue = findMaxValue(cars);

		for (Car car : cars) {
			if (car.getPosition() < maxValue) {
				break;
			}
			winner.add(car.getName());
		}

		System.out.printf("최종 우승자 : %s", String.join(", ", winner));
	}

	private static int findMaxValue(List<Car> cars) {
		cars.sort((x, y) -> y.getPosition() - x.getPosition());
		return cars.get(0).getPosition();
	}
}
