package racingcar;

import java.util.ArrayList;

import tools.InputTool;
import tools.PrintTool;

public class Game {
	private int currentMove = 0;
	private int maxMove;
	private Car[] cars;
	private ArrayList<String> winners;

	Game() {
	}

	public void initiateGame() {

		setCars(InputTool.getCarNames());
		setMaxMove(InputTool.getMaxMoves());
		playGame();
	}

	public void setCars(String[] carNames) {

		cars = new Car[carNames.length];
		for (int index = 0; index < carNames.length; index++) {
			cars[index] = new Car(carNames[index]);
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
		winners = findWinner();
		PrintTool.printWinners(winners);
	}

	public ArrayList<String> findWinner() {

		ArrayList<String> winners = new ArrayList<>();
		int maxPosition = findMaxPosition();

		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}
		return winners;
	}

}