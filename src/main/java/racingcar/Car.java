package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import tools.Utility;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {

		this.name = name;
	}

	public String getName() {

		return this.name;
	}

	public int getPosition() {

		return position;
	}

	public String getPositionString() {

		return Utility.repeatString(position, "-");
	}

	public void updatePosition() {

		if (canAdvance()) {
			position++;
		}
	}

	private boolean canAdvance() {

		return Randoms.pickNumberInRange(0, 9) >= 4;
	}

}
