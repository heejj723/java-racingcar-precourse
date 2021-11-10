package racinggame.controller;

import racinggame.model.Car;
import racinggame.model.Game;
import racinggame.model.Games;
import racinggame.view.InputView;
import racinggame.view.OutputView;

/**
 * 1. 자동차 이름에 대한 input 받기
 * - 잘못 된 값 (, 알파벳 이외) 에 대한 ERROR 처리
 * 2. 자동차 이름에 대해서 List 형태로 초기화 (모델)
 * 3. 게임 시작
 * - 랜덤으로 차 숫자만큼 숫자를 뽑는다.
 * - 4 이상인지 3 이하인지 판별한다
 *  - 4 이상: count++;
 *  - 3 이하: nothing
 * 4. 우승자를 판별한다
 * - 숫자가 큰 순서대로 출력한다.
 * */

public class CarController {

  public void playGame() {
    String carNames = InputView.getCarNames();
    int tryCount = Integer.parseInt(InputView.getTryCount());

    Games games = new Games(carNames, tryCount);
    printResult(games, tryCount);
    OutputView.printWinner(games.getWinners());
  }

  private void printResult(Games games, int tryCount) {
    OutputView.printResultMessage();
    for (int i = 0; i < tryCount; i++) {
      OutputView.printGameResult(games.getGameResult());
      System.out.println();
    }
  }




}
