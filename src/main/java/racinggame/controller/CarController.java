package racinggame.controller;

import java.util.List;
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
    List<Car> gameResult = games.getGameResult();
    OutputView.printResult(gameResult, tryCount);
    OutputView.printWinner(games.getWinners());
  }




}
