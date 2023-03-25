package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.name;
    }

    public int GenerateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public void CheckAdvance(int num) {
        if(this.GenerateRandomNumber()>=4) {
            this.position++;
        }
    }




}
