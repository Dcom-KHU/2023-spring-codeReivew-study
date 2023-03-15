package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
public class Car {
    private final String name;
    private int position = 0;
    public Car(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void printCar(){
        System.out.println(name+" : "+getPosition());
    }

    public void updatePosition(){

        if(canAdvance()){
            position++;
        }
    }
    public boolean canAdvance(){

        return pickNumberInRange(0, 9) >= 4;
    }

    public String getPosition(){

        return repeatString(position, "-");
    }

    public static String repeatString(int count, String str){
        StringBuilder result = new StringBuilder();
        for(int cnt = 0; cnt < count; cnt++){
            result.append(str);
        }
        return result.toString();
    }
}
