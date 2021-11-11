package racinggame.view;

import static nextstep.utils.Console.readLine;

public class InputView {

  private static final String CAR_NAME_INFO_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
  private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

  public static String getCarNames() {
    System.out.println(CAR_NAME_INFO_MESSAGE);
    return readLine();
  }

  public static String getTryCount() {
    System.out.println(TRY_COUNT_MESSAGE);
    return readLine();
  }
}
