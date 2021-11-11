package racinggame.controller;

import racinggame.model.Games;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class CarController {
  public void playGame() {
    Boolean wrongInputFlag = true;
    Games games = null;
    String tryCount = null;

    while(wrongInputFlag) {
      try {
        String carName = InputView.getCarNames();
        tryCount = InputView.getTryCount();
        games = Games.of(carName, tryCount);
        wrongInputFlag = false;
      } catch (Exception e) {
        OutputView.printError();
      }
    }
    OutputView.printResultMessage();
    for(int i = 0; i < Integer.parseInt(tryCount); i++) {
      OutputView.printGameResult(games.getResult());
    }

    OutputView.printWinner(games.getWinnersString());

  }




}
