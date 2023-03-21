package racingcar.model.domain;

import racingcar.dto.CarDTO;

public class Car implements Comparable<Car> {
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
        validateNumber(number);
        if (number >= 4)
            position++;
    }

    public void validateNumber(int number) {
        if (number < 0 || number > 9)
            throw new IllegalArgumentException("전진하는 조건은 0에서 9 사이의 숫자일 때입니다.");
    }

    public String getName() {
        return name;
    }

    public CarDTO to() {
        return new CarDTO(name, position);
    }

    @Override
    public int compareTo(Car anotherCar) {
        return anotherCar.position - this.position;
    }
}
