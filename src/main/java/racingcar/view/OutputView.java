package racingcar.view;

import racingcar.dto.CarDTO;
import racingcar.dto.CarStatusDTO;
import racingcar.view.utils.FormatParser;

import java.util.List;

public class OutputView {
    public void printGameResult(List<CarStatusDTO> carStatuses) {
        System.out.println("실행 결과");
        carStatuses.forEach(this::printCarStatuses);
    }

    private void printCarStatuses(CarStatusDTO carStatusDTO) {
        List<CarDTO> cars = carStatusDTO.getCars();
        cars.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(CarDTO carDTO) {
        System.out.printf("%s : %s" + System.lineSeparator(), carDTO.getName(),
                FormatParser.make(carDTO.getPosition(), "-")); // lineSeparator: 개행문자
    }

    public void printWinners(List<String> winnerNames) {
        System.out.printf("최종 우승자 : %s" + System.lineSeparator(),
                FormatParser.join(winnerNames, ", "));
    }

    public void printErrorMessage(String message) {
        System.out.printf("[ERROR] %s" + System.lineSeparator(), message);
    }
}
