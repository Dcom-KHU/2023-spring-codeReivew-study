package racingcar;

import java.util.ArrayList;
import java.util.List;

import tools.InputTool;
import tools.PrintTool;

public class Game {
	private int currentMove = 0;
	private int maxMove;
	private final List<Car> cars;

	Game() {
		cars = new ArrayList<>();
	}

	public void initiateGame() {

		setCars(InputTool.getCarNames());
		setMaxMove(InputTool.getMaxMoves());
		playGame();
	}

	public void setCars(String[] carNames) {

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void setMaxMove(int maxMove) {

		this.maxMove = maxMove;
	}

	public int findMaxPosition() {

		int maxPosition = 0;
		for (Car car : cars) {
			maxPosition = Math.max(maxPosition, car.getPosition());
		}
		return maxPosition;
	}

	public void playGame() {
		System.out.println("실행 결과");
		while (currentMove < maxMove) {
			PrintTool.printProgress(cars);
			currentMove++;
		}
		PrintTool.printWinners(findWinner());
	}

	public List<String> findWinner() {

		List<String> winners = new ArrayList<>();
		int maxPosition = findMaxPosition();

		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

}