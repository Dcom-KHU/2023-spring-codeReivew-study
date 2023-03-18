package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //getInput();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);

        String input = Console.readLine();

        String[] car_name = input.split(",");
        Car[] cars = new Car[car_name.length];



        int attempt =0;
        boolean validInput = false;

        //
        while(!validInput) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                attempt = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
                Console.readLine();
            }
        }

        System.out.println("\n실행 결과");

        //makeCarInstance
        for(int i=0; i< car_name.length; i++) {
            String carName = car_name[i];
            cars[i] = new Car(carName);
        }

        int[] distance_arr = new int[car_name.length];

        for(int j=0; j<attempt; j++) {
            for(int i=0; i< car_name.length; i++) {
                int check = cars[i].GenerateRandomNumber();
                if (cars[i].CheckAdvance(check)) {
                    cars[i].Advance();
                }
                cars[i].show_result();
                if(j == attempt-1) {
                    distance_arr[i] = cars[i].getDistance();
                }
            }
            System.out.println();
        }

        //checkMax
        int max = 0;

        for(int i=0; i< car_name.length; i++) {
            if(distance_arr[i]> max) {
                max = distance_arr[i];
            }
        }
        int cnt = 0;
        for(int i=0; i< car_name.length; i++) {
            if(distance_arr[i] == max) {
                cnt++;
            }
        }

        //printWinner carArray
        System.out.print("최초 우승자 : ");
        for(int i=0; i< car_name.length; i++) {
                if (distance_arr[i] == max) {
                    if (cnt > 1) {
                        System.out.print(cars[i].getName() + ", ");
                        cnt--;
                    }
                    else {
                        System.out.println(cars[i].getName());
                    }
                }
        }
    }

}
