package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    private int distance = 0;
    public Car(String name) {
        this.name = name;
    }

    public int GenerateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return this.name;
    }

    public boolean CheckAdvance(int num) {
        if(num>=4) {
            return true; }
        return false;
    }

    public void Advance() {
        this.distance++;
    }

    public void show_result() {
        System.out.print(this.name + " : ");
        for(int i=0; i<this.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void show_winner() {
        System.out.print("최종 우승자 : " + this.name);

    }


}
