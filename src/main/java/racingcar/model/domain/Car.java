package racingcar.model.domain;

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
}
