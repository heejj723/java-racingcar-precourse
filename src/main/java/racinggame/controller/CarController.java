package racinggame.controller;

import racinggame.model.Car;
import racinggame.model.Game;
import racinggame.model.Games;
import racinggame.view.InputView;
import racinggame.view.OutputView;

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
