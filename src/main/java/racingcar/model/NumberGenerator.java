package racingcar.model;

@FunctionalInterface // 1개의 추상 메소드를 갖는 인터페이스
public interface NumberGenerator {
    int make();
}