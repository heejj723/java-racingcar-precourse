package racinggame.model;

import java.util.List;

public class Games {

  private final String carNames;
  private final int round;
  private final Game game;

  public Games(String carNames, int round) {
    this.round = round;
    this.carNames = carNames;
    CarList carList = createCarList();
    this.game = new Game(carList);
  }

  public String getWinners() {
    List<Car> winners = game.carList.getCarsWithMaximumNumber();
    return carToString(winners);
  }

  public String carToString(List<Car> cars) {
    StringBuilder result = new StringBuilder();
    for (Car car : cars) {
      result.append(car.carName).append(",");
    }
    return result.substring(0, result.length()-1);
  }

  public List<Car> getGameResult() {
    return game.getResultOfRound();
  }

  private CarList createCarList() {
    return new CarList(carNames);
  }
}
