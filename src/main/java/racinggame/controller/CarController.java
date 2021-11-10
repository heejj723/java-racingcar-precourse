package racinggame.controller;

import com.sun.media.sound.InvalidFormatException;
import java.util.List;
import racinggame.model.Car;
import racinggame.model.Game;
import racinggame.model.Games;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class CarController {
  String carNames;
  int tryCount;

  public void playGame() {
    Boolean wrongInputFlag = true;
    Games games = null;
    while(wrongInputFlag) {
      carNames = InputView.getCarNames();
      tryCount = Integer.parseInt(InputView.getTryCount());
      try {
        games = Games.of(carNames, tryCount);
        wrongInputFlag = false;
      } catch (InvalidFormatException e) {
        OutputView.printError();
      }
    }
    OutputView.printResultMessage();
    for(int i = 0; i < tryCount; i++) {
      OutputView.printGameResult(games.getResult());
    }

    OutputView.printWinner(games.getWinnersString());

  }




}
