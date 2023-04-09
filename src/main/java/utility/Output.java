package utility;

import java.util.List;

import racingcar.Car;

public class Output {
	public static void printProcedure(List<Car> cars) {
		System.out.println("실행 결과");
		cars.forEach(car -> System.out.println(car.toString()));
		System.out.println();
	}

	public static void printResult(List<String> winners) {
		System.out.println("최종 우승자" + " : " + String.join(", ", winners));
	}

}
