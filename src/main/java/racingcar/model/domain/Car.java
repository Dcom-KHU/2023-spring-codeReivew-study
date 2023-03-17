package racingcar.model.domain;

import racingcar.dto.CarDTO;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차 이름이 다섯 글자를 초과합니다.");
    }

    public void move(int number) {
        if (number >= 4)
            position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public CarDTO to() {
        return new CarDTO(name, position);
    }
}
