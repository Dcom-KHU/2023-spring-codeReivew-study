package tools;

import java.util.List;

import racingcar.Car;

public class PrintTool {

	public static void printProgress(List<Car> cars) {
		for (Car car : cars) {
			car.updatePosition();
			printCarPosition(car);
		}
		System.out.println();
	}

	public static void printCarPosition(Car car) {

		System.out.println(car.getName() + " : " + car.getPositionString());
	}

	public static void printWinners(List<String> winners) {

		String str = String.join(", ", winners);
		System.out.println("최종 우승자 : " + str);
	}
}
