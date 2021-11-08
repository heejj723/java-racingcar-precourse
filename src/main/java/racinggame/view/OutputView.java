package racinggame.view;

public class OutputView {

  private static final String RESULT_MESSAGE = "실행 결과";

  public static void printCarName(String carName) {
    System.out.print(carName+":");
  }

  public static void printCountBar() {
    System.out.print("-");
  }

  public static void printResultMessage() {
    System.out.println(RESULT_MESSAGE);
  }

  public static void printWinner(String output) {
    System.out.println("최종 우승자는 " + output + " 입니다.");
  }

}
