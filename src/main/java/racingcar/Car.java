package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		String distance = new String(new char[this.getPosition()]).replace("\0", "-");
		return this.getName() + " : " + distance;
	}

	// 추가 기능 구현
	void move() {
		if (Randoms.pickNumberInRange(0, 9) >= 4) {
			this.position += 1;
		}
	}
}
