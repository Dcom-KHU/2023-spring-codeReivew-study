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

	public void updatePosition() {

		if (canAdvance()) {
			position++;
		}
	}

	public boolean canAdvance() {

		return Randoms.pickNumberInRange(0, 9) >= 4;
	}

	public int getPosition() {

		return position;
	}

	public String getPositionString() {

		return Utility.repeatString(position, "-");
	}

}
