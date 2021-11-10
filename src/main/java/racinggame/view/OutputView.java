package racinggame.view;

import java.util.List;
import racinggame.model.Car;

public class OutputView {

  private static final String RESULT_MESSAGE = "실행 결과";

  public static void printCarName(String carName) {
    System.out.print(carName+":");
  }

  public static void printCountBars(int count) {
    for (int i = 0; i < count; i++) {
      System.out.print("-");
    }
    System.out.println();
  }

  public static void printResultMessage() {
    System.out.println(RESULT_MESSAGE);
  }

  public static void printWinner(String output) {
    System.out.println("최종 우승자는 " + output + " 입니다.");
  }

  public static void printGameResult(List<Car> gameResult) {
    for (Car car : gameResult) {
      printCarName(car.carName);
      printCountBars(car.moveCount);
    }
  }
}
